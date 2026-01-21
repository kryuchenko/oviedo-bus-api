package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Throwables;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public class FileDataStoreFactory extends AbstractDataStoreFactory {
    private static final Logger LOGGER = Logger.getLogger(FileDataStoreFactory.class.getName());
    private final File dataDirectory;

    public FileDataStoreFactory(File file) throws Throwable {
        File canonicalFile = file.getCanonicalFile();
        this.dataDirectory = canonicalFile;
        if (IOUtils.isSymbolicLink(canonicalFile)) {
            throw new IOException("unable to use a symbolic link: " + canonicalFile);
        }
        if (!canonicalFile.exists() && !canonicalFile.mkdirs()) {
            throw new IOException("unable to create directory: " + canonicalFile);
        }
        setPermissionsToOwnerOnly(canonicalFile);
    }

    public final File getDataDirectory() {
        return this.dataDirectory;
    }

    @Override // com.google.api.client.util.store.AbstractDataStoreFactory
    protected <V extends Serializable> DataStore<V> createDataStore(String str) throws IOException {
        return new FileDataStore(this, this.dataDirectory, str);
    }

    static class FileDataStore<V extends Serializable> extends AbstractMemoryDataStore<V> {
        private final File dataFile;

        FileDataStore(FileDataStoreFactory fileDataStoreFactory, File file, String str) throws IOException {
            super(fileDataStoreFactory, str);
            File file2 = new File(file, str);
            this.dataFile = file2;
            if (IOUtils.isSymbolicLink(file2)) {
                throw new IOException("unable to use a symbolic link: " + file2);
            }
            if (file2.createNewFile()) {
                this.keyValueMap = Maps.newHashMap();
                save();
            } else {
                this.keyValueMap = (HashMap) IOUtils.deserialize(new FileInputStream(file2));
            }
        }

        @Override // com.google.api.client.util.store.AbstractMemoryDataStore
        public void save() throws IOException {
            IOUtils.serialize(this.keyValueMap, new FileOutputStream(this.dataFile));
        }

        @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
        public FileDataStoreFactory getDataStoreFactory() {
            return (FileDataStoreFactory) super.getDataStoreFactory();
        }
    }

    static void setPermissionsToOwnerOnly(File file) throws Throwable {
        try {
            Class cls = Boolean.TYPE;
            Method method = File.class.getMethod("setReadable", cls, cls);
            Class cls2 = Boolean.TYPE;
            Method method2 = File.class.getMethod("setWritable", cls2, cls2);
            Class cls3 = Boolean.TYPE;
            Method method3 = File.class.getMethod("setExecutable", cls3, cls3);
            if (!((Boolean) method.invoke(file, false, false)).booleanValue() || !((Boolean) method2.invoke(file, false, false)).booleanValue() || !((Boolean) method3.invoke(file, false, false)).booleanValue()) {
                LOGGER.warning("unable to change permissions for everybody: " + file);
            }
            if (((Boolean) method.invoke(file, true, true)).booleanValue() && ((Boolean) method2.invoke(file, true, true)).booleanValue() && ((Boolean) method3.invoke(file, true, true)).booleanValue()) {
                return;
            }
            LOGGER.warning("unable to change permissions for owner: " + file);
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException unused) {
        } catch (NoSuchMethodException unused2) {
            LOGGER.warning("Unable to set permissions for " + file + ", likely because you are running a version of Java prior to 1.6");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            Throwables.propagateIfPossible(cause, IOException.class);
            throw new RuntimeException(cause);
        }
    }
}
