package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import com.google.crypto.tink.shaded.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    private static boolean isEnforceUtf8(int i) {
        return (i & 536870912) != 0;
    }

    private static boolean isRequired(int i) {
        return (i & 268435456) != 0;
    }

    private static long offset(int i) {
        return i & OFFSET_MASK;
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x039f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        char cCharAt;
        int i6;
        char cCharAt2;
        int i7;
        char cCharAt3;
        int i8;
        char cCharAt4;
        int i9;
        char cCharAt5;
        int i10;
        char cCharAt6;
        int i11;
        char cCharAt7;
        int i12;
        char cCharAt8;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        String str;
        int i19;
        int iObjectFieldOffset2;
        int i20;
        Field fieldReflectField;
        char cCharAt9;
        int i21;
        int i22;
        Object obj;
        Field fieldReflectField2;
        Object obj2;
        Field fieldReflectField3;
        int i23;
        char cCharAt10;
        int i24;
        char cCharAt11;
        int i25;
        int i26;
        char cCharAt12;
        int i27;
        char cCharAt13;
        char cCharAt14;
        int i28 = 0;
        boolean z = rawMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        int iCharAt4 = stringInfo.charAt(0);
        if (iCharAt4 >= 55296) {
            int i29 = iCharAt4 & 8191;
            int i30 = 1;
            int i31 = 13;
            while (true) {
                i = i30 + 1;
                cCharAt14 = stringInfo.charAt(i30);
                if (cCharAt14 < 55296) {
                    break;
                }
                i29 |= (cCharAt14 & 8191) << i31;
                i31 += 13;
                i30 = i;
            }
            iCharAt4 = i29 | (cCharAt14 << i31);
        } else {
            i = 1;
        }
        int i32 = i + 1;
        int iCharAt5 = stringInfo.charAt(i);
        if (iCharAt5 >= 55296) {
            int i33 = iCharAt5 & 8191;
            int i34 = 13;
            while (true) {
                i27 = i32 + 1;
                cCharAt13 = stringInfo.charAt(i32);
                if (cCharAt13 < 55296) {
                    break;
                }
                i33 |= (cCharAt13 & 8191) << i34;
                i34 += 13;
                i32 = i27;
            }
            iCharAt5 = i33 | (cCharAt13 << i34);
            i32 = i27;
        }
        if (iCharAt5 == 0) {
            iArr = EMPTY_INT_ARRAY;
            i3 = 0;
            iCharAt = 0;
            i4 = 0;
            iCharAt2 = 0;
            i2 = 0;
            iCharAt3 = 0;
        } else {
            int i35 = i32 + 1;
            int iCharAt6 = stringInfo.charAt(i32);
            if (iCharAt6 >= 55296) {
                int i36 = iCharAt6 & 8191;
                int i37 = 13;
                while (true) {
                    i12 = i35 + 1;
                    cCharAt8 = stringInfo.charAt(i35);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt8 & 8191) << i37;
                    i37 += 13;
                    i35 = i12;
                }
                iCharAt6 = i36 | (cCharAt8 << i37);
                i35 = i12;
            }
            int i38 = i35 + 1;
            int iCharAt7 = stringInfo.charAt(i35);
            if (iCharAt7 >= 55296) {
                int i39 = iCharAt7 & 8191;
                int i40 = 13;
                while (true) {
                    i11 = i38 + 1;
                    cCharAt7 = stringInfo.charAt(i38);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt7 & 8191) << i40;
                    i40 += 13;
                    i38 = i11;
                }
                iCharAt7 = i39 | (cCharAt7 << i40);
                i38 = i11;
            }
            int i41 = i38 + 1;
            iCharAt = stringInfo.charAt(i38);
            if (iCharAt >= 55296) {
                int i42 = iCharAt & 8191;
                int i43 = 13;
                while (true) {
                    i10 = i41 + 1;
                    cCharAt6 = stringInfo.charAt(i41);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt6 & 8191) << i43;
                    i43 += 13;
                    i41 = i10;
                }
                iCharAt = i42 | (cCharAt6 << i43);
                i41 = i10;
            }
            int i44 = i41 + 1;
            int iCharAt8 = stringInfo.charAt(i41);
            if (iCharAt8 >= 55296) {
                int i45 = iCharAt8 & 8191;
                int i46 = 13;
                while (true) {
                    i9 = i44 + 1;
                    cCharAt5 = stringInfo.charAt(i44);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt5 & 8191) << i46;
                    i46 += 13;
                    i44 = i9;
                }
                iCharAt8 = i45 | (cCharAt5 << i46);
                i44 = i9;
            }
            int i47 = i44 + 1;
            int iCharAt9 = stringInfo.charAt(i44);
            if (iCharAt9 >= 55296) {
                int i48 = iCharAt9 & 8191;
                int i49 = 13;
                while (true) {
                    i8 = i47 + 1;
                    cCharAt4 = stringInfo.charAt(i47);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt4 & 8191) << i49;
                    i49 += 13;
                    i47 = i8;
                }
                iCharAt9 = i48 | (cCharAt4 << i49);
                i47 = i8;
            }
            int i50 = i47 + 1;
            iCharAt2 = stringInfo.charAt(i47);
            if (iCharAt2 >= 55296) {
                int i51 = iCharAt2 & 8191;
                int i52 = 13;
                while (true) {
                    i7 = i50 + 1;
                    cCharAt3 = stringInfo.charAt(i50);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt3 & 8191) << i52;
                    i52 += 13;
                    i50 = i7;
                }
                iCharAt2 = i51 | (cCharAt3 << i52);
                i50 = i7;
            }
            int i53 = i50 + 1;
            int iCharAt10 = stringInfo.charAt(i50);
            if (iCharAt10 >= 55296) {
                int i54 = iCharAt10 & 8191;
                int i55 = 13;
                while (true) {
                    i6 = i53 + 1;
                    cCharAt2 = stringInfo.charAt(i53);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt2 & 8191) << i55;
                    i55 += 13;
                    i53 = i6;
                }
                iCharAt10 = i54 | (cCharAt2 << i55);
                i53 = i6;
            }
            int i56 = i53 + 1;
            iCharAt3 = stringInfo.charAt(i53);
            if (iCharAt3 >= 55296) {
                int i57 = iCharAt3 & 8191;
                int i58 = i56;
                int i59 = 13;
                while (true) {
                    i5 = i58 + 1;
                    cCharAt = stringInfo.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i57 |= (cCharAt & 8191) << i59;
                    i59 += 13;
                    i58 = i5;
                }
                iCharAt3 = i57 | (cCharAt << i59);
                i56 = i5;
            }
            int[] iArr2 = new int[iCharAt3 + iCharAt2 + iCharAt10];
            i2 = (iCharAt6 * 2) + iCharAt7;
            i3 = iCharAt8;
            i4 = iCharAt9;
            iArr = iArr2;
            i28 = iCharAt6;
            i32 = i56;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr3 = new int[i4 * 3];
        Object[] objArr = new Object[i4 * 2];
        int i60 = iCharAt2 + iCharAt3;
        int i61 = i60;
        int i62 = iCharAt3;
        int i63 = 0;
        int i64 = 0;
        while (i32 < length) {
            int i65 = i32 + 1;
            int iCharAt11 = stringInfo.charAt(i32);
            int i66 = length;
            if (iCharAt11 >= 55296) {
                int i67 = iCharAt11 & 8191;
                int i68 = i65;
                int i69 = 13;
                while (true) {
                    i26 = i68 + 1;
                    cCharAt12 = stringInfo.charAt(i68);
                    i13 = i28;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i67 |= (cCharAt12 & 8191) << i69;
                    i69 += 13;
                    i68 = i26;
                    i28 = i13;
                }
                iCharAt11 = i67 | (cCharAt12 << i69);
                i14 = i26;
            } else {
                i13 = i28;
                i14 = i65;
            }
            int i70 = i14 + 1;
            int iCharAt12 = stringInfo.charAt(i14);
            if (iCharAt12 >= 55296) {
                int i71 = iCharAt12 & 8191;
                int i72 = i70;
                int i73 = 13;
                while (true) {
                    i24 = i72 + 1;
                    cCharAt11 = stringInfo.charAt(i72);
                    i25 = i71;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i71 = i25 | ((cCharAt11 & 8191) << i73);
                    i73 += 13;
                    i72 = i24;
                }
                iCharAt12 = i25 | (cCharAt11 << i73);
                i15 = i24;
            } else {
                i15 = i70;
            }
            int i74 = iCharAt4;
            int i75 = iCharAt12 & 255;
            int[] iArr4 = iArr3;
            if ((iCharAt12 & 1024) != 0) {
                iArr[i63] = i64;
                i63++;
            }
            int i76 = iCharAt11;
            if (i75 >= 51) {
                int i77 = i15 + 1;
                int iCharAt13 = stringInfo.charAt(i15);
                char c = 55296;
                if (iCharAt13 >= 55296) {
                    int i78 = iCharAt13 & 8191;
                    int i79 = 13;
                    while (true) {
                        i23 = i77 + 1;
                        cCharAt10 = stringInfo.charAt(i77);
                        if (cCharAt10 < c) {
                            break;
                        }
                        i78 |= (cCharAt10 & 8191) << i79;
                        i79 += 13;
                        i77 = i23;
                        c = 55296;
                    }
                    iCharAt13 = i78 | (cCharAt10 << i79);
                    i77 = i23;
                }
                int i80 = i75 - 51;
                int i81 = iCharAt13;
                if (i80 == 9 || i80 == 17) {
                    i22 = i2 + 1;
                    objArr[((i64 / 3) * 2) + 1] = objects[i2];
                } else {
                    if (i80 == 12 && (i74 & 1) == 1) {
                        i22 = i2 + 1;
                        objArr[((i64 / 3) * 2) + 1] = objects[i2];
                    }
                    int i82 = i81 * 2;
                    obj = objects[i82];
                    if (!(obj instanceof Field)) {
                        fieldReflectField2 = (Field) obj;
                    } else {
                        fieldReflectField2 = reflectField(cls, (String) obj);
                        objects[i82] = fieldReflectField2;
                    }
                    int i83 = i77;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                    int i84 = i82 + 1;
                    obj2 = objects[i84];
                    if (!(obj2 instanceof Field)) {
                        fieldReflectField3 = (Field) obj2;
                    } else {
                        fieldReflectField3 = reflectField(cls, (String) obj2);
                        objects[i84] = fieldReflectField3;
                    }
                    str = stringInfo;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                    i18 = i2;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i20 = 0;
                    i17 = iCharAt;
                    i19 = i83;
                    i16 = i3;
                }
                i2 = i22;
                int i822 = i81 * 2;
                obj = objects[i822];
                if (!(obj instanceof Field)) {
                }
                int i832 = i77;
                int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                int i842 = i822 + 1;
                obj2 = objects[i842];
                if (!(obj2 instanceof Field)) {
                }
                str = stringInfo;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                i18 = i2;
                iObjectFieldOffset = iObjectFieldOffset32;
                i20 = 0;
                i17 = iCharAt;
                i19 = i832;
                i16 = i3;
            } else {
                int i85 = i2 + 1;
                Field fieldReflectField4 = reflectField(cls, (String) objects[i2]);
                if (i75 == 9 || i75 == 17) {
                    i16 = i3;
                    objArr[((i64 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i75 == 27 || i75 == 49) {
                        i16 = i3;
                        i21 = i2 + 2;
                        objArr[((i64 / 3) * 2) + 1] = objects[i85];
                    } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                        i16 = i3;
                        if ((i74 & 1) == 1) {
                            i21 = i2 + 2;
                            objArr[((i64 / 3) * 2) + 1] = objects[i85];
                        }
                    } else if (i75 == 50) {
                        int i86 = i62 + 1;
                        iArr[i62] = i64;
                        int i87 = (i64 / 3) * 2;
                        int i88 = i2 + 2;
                        objArr[i87] = objects[i85];
                        if ((iCharAt12 & 2048) != 0) {
                            i18 = i2 + 3;
                            objArr[i87 + 1] = objects[i88];
                            i16 = i3;
                            i17 = iCharAt;
                            i62 = i86;
                        } else {
                            i17 = iCharAt;
                            i18 = i88;
                            i62 = i86;
                            i16 = i3;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                        if ((i74 & 1) != 1 || i75 > 17) {
                            str = stringInfo;
                            i19 = i15;
                            iObjectFieldOffset2 = 0;
                            i20 = 0;
                        } else {
                            int i89 = i15 + 1;
                            int iCharAt14 = stringInfo.charAt(i15);
                            if (iCharAt14 >= 55296) {
                                int i90 = iCharAt14 & 8191;
                                int i91 = 13;
                                while (true) {
                                    i19 = i89 + 1;
                                    cCharAt9 = stringInfo.charAt(i89);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i90 |= (cCharAt9 & 8191) << i91;
                                    i91 += 13;
                                    i89 = i19;
                                }
                                iCharAt14 = i90 | (cCharAt9 << i91);
                            } else {
                                i19 = i89;
                            }
                            int i92 = (i13 * 2) + (iCharAt14 / 32);
                            Object obj3 = objects[i92];
                            str = stringInfo;
                            if (obj3 instanceof Field) {
                                fieldReflectField = (Field) obj3;
                            } else {
                                fieldReflectField = reflectField(cls, (String) obj3);
                                objects[i92] = fieldReflectField;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                            i20 = iCharAt14 % 32;
                        }
                        if (i75 >= 18 && i75 <= 49) {
                            iArr[i61] = iObjectFieldOffset;
                            i61++;
                        }
                    } else {
                        i16 = i3;
                    }
                    i18 = i21;
                    i17 = iCharAt;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                    if ((i74 & 1) != 1) {
                        str = stringInfo;
                        i19 = i15;
                        iObjectFieldOffset2 = 0;
                        i20 = 0;
                        if (i75 >= 18) {
                            iArr[i61] = iObjectFieldOffset;
                            i61++;
                        }
                    }
                }
                i17 = iCharAt;
                i18 = i85;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((i74 & 1) != 1) {
                }
            }
            int i93 = i64 + 1;
            iArr4[i64] = i76;
            int i94 = i64 + 2;
            int i95 = iObjectFieldOffset2;
            iArr4[i93] = ((iCharAt12 & 512) != 0 ? 536870912 : 0) | ((iCharAt12 & 256) != 0 ? 268435456 : 0) | (i75 << 20) | iObjectFieldOffset;
            i64 += 3;
            iArr4[i94] = (i20 << 20) | i95;
            iCharAt = i17;
            iCharAt4 = i74;
            length = i66;
            i28 = i13;
            i3 = i16;
            i32 = i19;
            stringInfo = str;
            i2 = i18;
            iArr3 = iArr4;
        }
        return new MessageSchema<>(iArr3, objArr, iCharAt, i3, rawMessageInfo.getDefaultInstance(), z, false, iArr, iCharAt3, i60, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i;
        boolean z = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i2 = 0;
        int i3 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i2++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i3++;
            }
        }
        int[] iArr2 = i2 > 0 ? new int[i2] : null;
        int[] iArr3 = i3 > 0 ? new int[i3] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i4 < fields.length) {
            FieldInfo fieldInfo2 = fields[i4];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i5, z, objArr);
            if (i6 < checkInitialized.length && checkInitialized[i6] == fieldNumber3) {
                checkInitialized[i6] = i5;
                i6++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i7] = i5;
                i7++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    i = i5;
                    iArr3[i8] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i8++;
                }
                i4++;
                i5 = i + 3;
            }
            i = i5;
            i4++;
            i5 = i + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i, boolean z, Object[] objArr) {
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int iId;
        int iNumberOfTrailingZeros;
        int i2;
        OneofInfo oneof = fieldInfo.getOneof();
        if (oneof != null) {
            iId = fieldInfo.getType().id() + 51;
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
            iObjectFieldOffset2 = (int) UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        } else {
            FieldType type = fieldInfo.getType();
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            int iId2 = type.id();
            if (!z && !type.isList() && !type.isMap()) {
                int iObjectFieldOffset3 = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getPresenceField());
                iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
                iId = iId2;
                i2 = iObjectFieldOffset3;
            } else if (fieldInfo.getCachedSizeField() == null) {
                iId = iId2;
                iNumberOfTrailingZeros = 0;
                i2 = 0;
            } else {
                iObjectFieldOffset2 = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
                iId = iId2;
            }
            iArr[i] = fieldInfo.getFieldNumber();
            iArr[i + 1] = (iId << 20) | (fieldInfo.isRequired() ? 268435456 : 0) | (!fieldInfo.isEnforceUtf8() ? 536870912 : 0) | iObjectFieldOffset;
            iArr[i + 2] = (iNumberOfTrailingZeros << 20) | i2;
            Class<?> messageFieldClass = fieldInfo.getMessageFieldClass();
            if (fieldInfo.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objArr[((i / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else {
                    if (fieldInfo.getEnumVerifier() != null) {
                        objArr[((i / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            int i3 = (i / 3) * 2;
            objArr[i3] = fieldInfo.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objArr[i3 + 1] = messageFieldClass;
                return;
            } else {
                if (fieldInfo.getEnumVerifier() != null) {
                    objArr[i3 + 1] = fieldInfo.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        i2 = iObjectFieldOffset2;
        iNumberOfTrailingZeros = 0;
        iArr[i] = fieldInfo.getFieldNumber();
        if (!fieldInfo.isEnforceUtf8()) {
        }
        iArr[i + 1] = (iId << 20) | (fieldInfo.isRequired() ? 268435456 : 0) | (!fieldInfo.isEnforceUtf8() ? 536870912 : 0) | iObjectFieldOffset;
        iArr[i + 2] = (iNumberOfTrailingZeros << 20) | i2;
        Class<?> messageFieldClass2 = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() != null) {
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    private boolean equals(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (!arePresentForEquals(t, t2, i) || Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)) != Double.doubleToLongBits(UnsafeUtil.getDouble(t2, jOffset))) {
                }
                break;
            case 1:
                if (!arePresentForEquals(t, t2, i) || Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset)) != Float.floatToIntBits(UnsafeUtil.getFloat(t2, jOffset))) {
                }
                break;
            case 2:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 3:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 4:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 5:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 6:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 7:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getBoolean(t, jOffset) != UnsafeUtil.getBoolean(t2, jOffset)) {
                }
                break;
            case 8:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 9:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 10:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 11:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 12:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 13:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 14:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 15:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 16:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 17:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!isOneofCaseEqual(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int hashCode(T t) {
        int i;
        int iHashLong;
        int length = this.buffer.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i3);
            int iNumberAt = numberAt(i3);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)));
                    i2 = i + iHashLong;
                    break;
                case 1:
                    i = i2 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 2:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 3:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 4:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 5:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 6:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 7:
                    i = i2 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 8:
                    i = i2 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 11:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 12:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 13:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 14:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 15:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 16:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 50:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, jOffset)));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t, jOffset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t, jOffset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.unknownFieldSchema.getFromMessage(t).hashCode();
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t).hashCode() : iHashCode2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble(t, jOffset, UnsafeUtil.getDouble(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat(t, jOffset, UnsafeUtil.getFloat(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean(t, jOffset, UnsafeUtil.getBoolean(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 9:
                mergeMessage(t, t2, i);
                break;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 17:
                mergeMessage(t, t2, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                    break;
                }
                break;
            case 60:
                mergeOneofMessage(t, t2, i);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                    break;
                }
                break;
            case 68:
                mergeOneofMessage(t, t2, i);
                break;
        }
    }

    private void mergeMessage(T t, T t2, int i) {
        long jOffset = offset(typeAndOffsetAt(i));
        if (isFieldPresent(t2, i)) {
            Object object = UnsafeUtil.getObject(t, jOffset);
            Object object2 = UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, jOffset, Internal.mergeMessage(object, object2));
                setFieldPresent(t, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, jOffset, object2);
                setFieldPresent(t, i);
            }
        }
    }

    private void mergeOneofMessage(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        int iNumberAt = numberAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        if (isOneofPresent(t2, iNumberAt, i)) {
            Object object = UnsafeUtil.getObject(t, jOffset);
            Object object2 = UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, jOffset, Internal.mergeMessage(object, object2));
                setOneofPresent(t, iNumberAt, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, jOffset, object2);
                setOneofPresent(t, iNumberAt, i);
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int getSerializedSize(T t) {
        return this.proto3 ? getSerializedSizeProto3(t) : getSerializedSizeProto2(t);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getSerializedSizeProto2(T t) {
        int i;
        int i2;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeSFixed32Size;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i4);
            int iNumberAt = numberAt(i4);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                i = this.buffer[i4 + 2];
                int i7 = OFFSET_MASK & i;
                int i8 = 1 << (i >>> 20);
                if (i7 != i3) {
                    i6 = unsafe.getInt(t, i7);
                    i3 = i7;
                }
                i2 = i8;
            } else {
                i = (!this.useCachedSizeField || iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i4 + 2] & OFFSET_MASK;
                i2 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            int i9 = i3;
            switch (iType) {
                case 0:
                    if ((i6 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i5 += iComputeDoubleSize;
                        break;
                    }
                case 1:
                    if ((i6 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i5 += iComputeDoubleSize;
                        break;
                    }
                case 2:
                    if ((i6 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i5 += iComputeDoubleSize;
                        break;
                    }
                case 3:
                    if ((i6 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i5 += iComputeDoubleSize;
                        break;
                    }
                case 4:
                    if ((i6 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i5 += iComputeDoubleSize;
                        break;
                    }
                case 5:
                    if ((i6 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i5 += iComputeDoubleSize;
                        break;
                    }
                case 6:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i5 += iComputeDoubleSize;
                        break;
                    }
                    break;
                case 7:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if ((i6 & i2) != 0) {
                        Object object = unsafe.getObject(t, jOffset);
                        if (object instanceof ByteString) {
                            iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object);
                        } else {
                            iComputeBoolSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        }
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 9:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 10:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if ((i6 & i2) != 0) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 14:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 19:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 20:
                    iComputeBoolSize = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 21:
                    iComputeBoolSize = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 22:
                    iComputeBoolSize = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 23:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 24:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 25:
                    iComputeBoolSize = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 26:
                    iComputeBoolSize = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    i5 += iComputeBoolSize;
                    break;
                case 27:
                    iComputeBoolSize = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    i5 += iComputeBoolSize;
                    break;
                case 28:
                    iComputeBoolSize = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    i5 += iComputeBoolSize;
                    break;
                case 29:
                    iComputeBoolSize = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 30:
                    iComputeBoolSize = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 31:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 32:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 33:
                    iComputeBoolSize = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 34:
                    iComputeBoolSize = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 49:
                    iComputeBoolSize = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    i5 += iComputeBoolSize;
                    break;
                case 50:
                    iComputeBoolSize = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t, jOffset), getMapFieldDefaultEntry(i4));
                    i5 += iComputeBoolSize;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeSFixed32Size = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        Object object2 = unsafe.getObject(t, jOffset);
                        if (object2 instanceof ByteString) {
                            iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2);
                        } else {
                            iComputeBoolSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        }
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
            }
            i4 += 3;
            i3 = i9;
        }
        int unknownFieldsSerializedSize = i5 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t) {
        int iComputeDoubleSize;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i = 0;
        for (int i2 = 0; i2 < this.buffer.length; i2 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i2);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i2);
            long jOffset = offset(iTypeAndOffsetAt);
            int i3 = (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i2 + 2] & OFFSET_MASK;
            switch (iType) {
                case 0:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(t, i2)) {
                        Object object = UnsafeUtil.getObject(t, jOffset);
                        if (object instanceof ByteString) {
                            iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object);
                        } else {
                            iComputeDoubleSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        }
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 19:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 20:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 21:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 22:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 23:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 24:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 25:
                    iComputeDoubleSize = SchemaUtil.computeSizeBoolList(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 26:
                    iComputeDoubleSize = SchemaUtil.computeSizeStringList(iNumberAt, listAt(t, jOffset));
                    i += iComputeDoubleSize;
                    break;
                case 27:
                    iComputeDoubleSize = SchemaUtil.computeSizeMessageList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i2));
                    i += iComputeDoubleSize;
                    break;
                case 28:
                    iComputeDoubleSize = SchemaUtil.computeSizeByteStringList(iNumberAt, listAt(t, jOffset));
                    i += iComputeDoubleSize;
                    break;
                case 29:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 30:
                    iComputeDoubleSize = SchemaUtil.computeSizeEnumList(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 31:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 32:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 33:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt32List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 34:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt64List(iNumberAt, listAt(t, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 49:
                    iComputeDoubleSize = SchemaUtil.computeSizeGroupList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i2));
                    i += iComputeDoubleSize;
                    break;
                case 50:
                    iComputeDoubleSize = this.mapFieldSchema.getSerializedSize(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMapFieldDefaultEntry(i2));
                    i += iComputeDoubleSize;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        Object object2 = UnsafeUtil.getObject(t, jOffset);
                        if (object2 instanceof ByteString) {
                            iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2);
                        } else {
                            iComputeDoubleSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        }
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t));
    }

    private static List<?> listAt(Object obj, long j) {
        return (List) UnsafeUtil.getObject(obj, j);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void writeTo(T t, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t, writer);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrderProto2(T t, Writer writer) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        int i;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.buffer.length;
        Unsafe unsafe = UNSAFE;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i3);
            int iNumberAt = numberAt(i3);
            int iType = type(iTypeAndOffsetAt);
            if (this.proto3 || iType > 17) {
                entry = entry;
                i = 0;
            } else {
                int i5 = this.buffer[i3 + 2];
                int i6 = i5 & OFFSET_MASK;
                Map.Entry<?, ?> entry2 = entry;
                if (i6 != i2) {
                    i4 = unsafe.getInt(t, i6);
                    i2 = i6;
                }
                i = 1 << (i5 >>> 20);
                entry = entry2;
            }
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            Iterator it2 = it;
            int i7 = i;
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i4 & i7) != 0) {
                        writer.writeDouble(iNumberAt, doubleAt(t, jOffset));
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 1:
                    if ((i4 & i7) != 0) {
                        writer.writeFloat(iNumberAt, floatAt(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 2:
                    if ((i4 & i7) != 0) {
                        writer.writeInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 3:
                    if ((i4 & i7) != 0) {
                        writer.writeUInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 4:
                    if ((i4 & i7) != 0) {
                        writer.writeInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 5:
                    if ((i4 & i7) != 0) {
                        writer.writeFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 6:
                    if ((i4 & i7) != 0) {
                        writer.writeFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 7:
                    if ((i4 & i7) != 0) {
                        writer.writeBool(iNumberAt, booleanAt(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 8:
                    if ((i4 & i7) != 0) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 9:
                    if ((i4 & i7) != 0) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 10:
                    if ((i4 & i7) != 0) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 11:
                    if ((i4 & i7) != 0) {
                        writer.writeUInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 12:
                    if ((i4 & i7) != 0) {
                        writer.writeEnum(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 13:
                    if ((i4 & i7) != 0) {
                        writer.writeSFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 14:
                    if ((i4 & i7) != 0) {
                        writer.writeSFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 15:
                    if ((i4 & i7) != 0) {
                        writer.writeSInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 16:
                    if ((i4 & i7) != 0) {
                        writer.writeSInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 17:
                    if ((i4 & i7) != 0) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    it = it2;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    it = it2;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    it = it2;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    it = it2;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    it = it2;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    it = it2;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    it = it2;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    it = it2;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    it = it2;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i3));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i3), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i3));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, unsafe.getObject(t, jOffset), i3);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, jOffset));
                        break;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, jOffset));
                        break;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, jOffset));
                        break;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, jOffset));
                        break;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, jOffset));
                        break;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, jOffset));
                        break;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, jOffset));
                        break;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, jOffset));
                        break;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                        break;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i3));
                        break;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        break;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, jOffset));
                        break;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, jOffset));
                        break;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, jOffset));
                        break;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, jOffset));
                        break;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, jOffset));
                        break;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, jOffset));
                        break;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i3));
                        break;
                    }
                    break;
            }
            i3 += 3;
            it = it2;
        }
        Iterator it3 = it;
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it3.hasNext() ? (Map.Entry) it3.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrderProto3(T t, Writer writer) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            int iNumberAt = numberAt(i);
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, i)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(t, i)) {
                        writer.writeFloat(iNumberAt, floatAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(t, i)) {
                        writer.writeInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(t, i)) {
                        writer.writeUInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(t, i)) {
                        writer.writeInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(t, i)) {
                        writer.writeFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(t, i)) {
                        writer.writeFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(t, i)) {
                        writer.writeBool(iNumberAt, booleanAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(t, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(t, i)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(t, i)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(t, i)) {
                        writer.writeUInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(t, i)) {
                        writer.writeEnum(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(t, i)) {
                        writer.writeSFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(t, i)) {
                        writer.writeSFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(t, i)) {
                        writer.writeSInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(t, i)) {
                        writer.writeSInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(t, i)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(i));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(i));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), i);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInDescendingOrder(T t, Writer writer) throws IOException {
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry;
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                itDescendingIterator = null;
                entry = null;
            } else {
                itDescendingIterator = extensions.descendingIterator();
                entry = (Map.Entry) itDescendingIterator.next();
            }
        }
        for (int length = this.buffer.length - 3; length >= 0; length -= 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(length);
            int iNumberAt = numberAt(length);
            while (entry != null && this.extensionSchema.extensionNumber(entry) > iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, length)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(t, length)) {
                        writer.writeFloat(iNumberAt, floatAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(t, length)) {
                        writer.writeBool(iNumberAt, booleanAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(t, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(t, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(t, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(t, length)) {
                        writer.writeEnum(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(t, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), length);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                        break;
                    } else {
                        break;
                    }
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, Writer writer) throws IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t), writer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    /* JADX WARN: Code restructure failed: missing block: B:333:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0076, code lost:
    
        r0 = r14.checkInitializedCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007a, code lost:
    
        if (r0 >= r14.repeatedFieldOffsetStart) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007c, code lost:
    
        r7 = filterMapUnknownEnumValues(r9, r14.intArray[r0], r7, r15);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0087, code lost:
    
        if (r7 == null) goto L333;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0631 A[LOOP:3: B:196:0x062d->B:198:0x0631, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0601 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05e6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        int i;
        ExtensionSchema<ET> extensionSchema2;
        Object objFindExtensionByNumber;
        Object obj;
        T t2 = t;
        ExtensionRegistryLite extensionRegistryLite2 = extensionRegistryLite;
        Object objFilterMapUnknownEnumValues = null;
        Object mutableExtensions = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int iPositionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (iPositionForFieldNumber >= 0) {
                    Reader reader2 = reader;
                    obj = objFilterMapUnknownEnumValues;
                    int iTypeAndOffsetAt = typeAndOffsetAt(iPositionForFieldNumber);
                    switch (type(iTypeAndOffsetAt)) {
                        case 0:
                            UnsafeUtil.putDouble(t2, offset(iTypeAndOffsetAt), reader2.readDouble());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 1:
                            UnsafeUtil.putFloat(t2, offset(iTypeAndOffsetAt), reader2.readFloat());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 2:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 3:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readUInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 4:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 5:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readFixed64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 6:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readFixed32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 7:
                            UnsafeUtil.putBoolean(t2, offset(iTypeAndOffsetAt), reader2.readBool());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 8:
                            readString(t2, iTypeAndOffsetAt, reader2);
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 9:
                            if (isFieldPresent(t2, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            objFilterMapUnknownEnumValues = obj;
                        case 10:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readBytes());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 11:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readUInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 12:
                            int i2 = reader2.readEnum();
                            Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(iPositionForFieldNumber);
                            if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i2)) {
                                objFilterMapUnknownEnumValues = SchemaUtil.storeUnknownEnum(fieldNumber, i2, obj, unknownFieldSchema);
                            }
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), i2);
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 13:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readSFixed32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 14:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readSFixed64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 15:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readSInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 16:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readSInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 17:
                            if (isFieldPresent(t2, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            objFilterMapUnknownEnumValues = obj;
                        case 18:
                            reader2.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                        case 19:
                            reader2.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                        case 20:
                            reader2.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                        case 21:
                            reader2.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                        case 22:
                            reader2.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                        case 23:
                            reader2.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                        case 24:
                            reader2.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                        case 25:
                            reader2.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                        case 26:
                            readStringList(t2, iTypeAndOffsetAt, reader2);
                            objFilterMapUnknownEnumValues = obj;
                        case 27:
                            T t3 = t2;
                            try {
                                readMessageList(t3, iTypeAndOffsetAt, reader2, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                t2 = t3;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                t2 = t3;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            }
                            break;
                        case 28:
                            reader2.readBytesList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 29:
                            reader2.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 30:
                            List<Integer> listMutableListAt = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                            reader2.readEnumList(listMutableListAt);
                            objFilterMapUnknownEnumValues = SchemaUtil.filterUnknownEnumList(fieldNumber, listMutableListAt, getEnumFieldVerifier(iPositionForFieldNumber), obj, unknownFieldSchema);
                            extensionRegistryLite2 = extensionRegistryLite;
                        case 31:
                            reader2.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 32:
                            reader2.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 33:
                            reader2.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 34:
                            reader2.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 35:
                            reader2.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 36:
                            reader2.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 37:
                            reader2.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 38:
                            reader2.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 39:
                            reader2.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 40:
                            reader2.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 41:
                            reader2.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 42:
                            reader2.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 43:
                            reader2.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 44:
                            List<Integer> listMutableListAt2 = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                            reader2.readEnumList(listMutableListAt2);
                            objFilterMapUnknownEnumValues = SchemaUtil.filterUnknownEnumList(fieldNumber, listMutableListAt2, getEnumFieldVerifier(iPositionForFieldNumber), obj, unknownFieldSchema);
                            extensionRegistryLite2 = extensionRegistryLite;
                        case 45:
                            reader2.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 46:
                            reader2.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 47:
                            reader2.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                        case 48:
                            try {
                                reader2.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            }
                            break;
                        case 49:
                            try {
                                try {
                                    readGroupList(t, offset(iTypeAndOffsetAt), reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                    t2 = t;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    objFilterMapUnknownEnumValues = obj;
                                } catch (Throwable th) {
                                    th = th;
                                    t2 = t;
                                    objFilterMapUnknownEnumValues = obj;
                                    for (i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                    throw th;
                                }
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                t2 = t;
                                reader2 = reader;
                                objFilterMapUnknownEnumValues = obj;
                                extensionRegistryLite2 = extensionRegistryLite;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            }
                            break;
                        case 50:
                            try {
                                mergeMap(t2, iPositionForFieldNumber, getMapFieldDefaultEntry(iPositionForFieldNumber), extensionRegistryLite2, reader);
                                t2 = t;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                                t2 = t;
                                reader2 = reader;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                t2 = t;
                                objFilterMapUnknownEnumValues = obj;
                                while (i < this.repeatedFieldOffsetStart) {
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                }
                                throw th;
                            }
                            break;
                        case 51:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Double.valueOf(reader2.readDouble()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 52:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Float.valueOf(reader2.readFloat()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 53:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 54:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readUInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 55:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 56:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readFixed64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 57:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readFixed32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 58:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Boolean.valueOf(reader2.readBool()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 59:
                            readString(t2, iTypeAndOffsetAt, reader2);
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 60:
                            if (isOneofPresent(t2, fieldNumber, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 61:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readBytes());
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 62:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readUInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 63:
                            int i3 = reader2.readEnum();
                            Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(iPositionForFieldNumber);
                            if (enumFieldVerifier2 != null && !enumFieldVerifier2.isInRange(i3)) {
                                objFilterMapUnknownEnumValues = SchemaUtil.storeUnknownEnum(fieldNumber, i3, obj, unknownFieldSchema);
                            }
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(i3));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 64:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readSFixed32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 65:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readSFixed64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 66:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readSInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 67:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readSInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        case 68:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                        default:
                            objFilterMapUnknownEnumValues = obj == null ? unknownFieldSchema.newBuilder() : obj;
                            try {
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused5) {
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                    if (objFilterMapUnknownEnumValues == null) {
                                        objFilterMapUnknownEnumValues = unknownFieldSchema.getBuilderFromMessage(t2);
                                    }
                                    if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                        for (int i4 = this.checkInitializedCount; i4 < this.repeatedFieldOffsetStart; i4++) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i4], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                        }
                                        if (objFilterMapUnknownEnumValues == null) {
                                            return;
                                        }
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                        return;
                                    }
                                } else if (!reader2.skipField()) {
                                    for (int i5 = this.checkInitializedCount; i5 < this.repeatedFieldOffsetStart; i5++) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i5], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues == null) {
                                        return;
                                    }
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    return;
                                }
                            }
                            if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                for (int i6 = this.checkInitializedCount; i6 < this.repeatedFieldOffsetStart; i6++) {
                                    objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i6], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                }
                                if (objFilterMapUnknownEnumValues == null) {
                                    return;
                                }
                            }
                    }
                } else if (fieldNumber == Integer.MAX_VALUE) {
                    for (int i7 = this.checkInitializedCount; i7 < this.repeatedFieldOffsetStart; i7++) {
                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i7], objFilterMapUnknownEnumValues, unknownFieldSchema);
                    }
                    if (objFilterMapUnknownEnumValues == null) {
                        return;
                    }
                } else {
                    if (this.hasExtensions) {
                        extensionSchema2 = extensionSchema;
                        objFindExtensionByNumber = extensionSchema2.findExtensionByNumber(extensionRegistryLite2, this.defaultInstance, fieldNumber);
                    } else {
                        extensionSchema2 = extensionSchema;
                        objFindExtensionByNumber = null;
                    }
                    if (objFindExtensionByNumber != null) {
                        if (mutableExtensions == null) {
                            try {
                                mutableExtensions = extensionSchema.getMutableExtensions(t);
                            } catch (Throwable th3) {
                                th = th3;
                                while (i < this.repeatedFieldOffsetStart) {
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                }
                                throw th;
                            }
                        }
                        FieldSet<T> fieldSet = mutableExtensions;
                        objFilterMapUnknownEnumValues = extensionSchema2.parseExtension(reader, objFindExtensionByNumber, extensionRegistryLite2, fieldSet, objFilterMapUnknownEnumValues, unknownFieldSchema);
                        mutableExtensions = fieldSet;
                    } else {
                        obj = objFilterMapUnknownEnumValues;
                        try {
                            if (unknownFieldSchema.shouldDiscardUnknownFields(reader)) {
                                if (!reader.skipField()) {
                                    objFilterMapUnknownEnumValues = obj;
                                }
                                objFilterMapUnknownEnumValues = obj;
                            } else {
                                objFilterMapUnknownEnumValues = obj == null ? unknownFieldSchema.getBuilderFromMessage(t2) : obj;
                                if (unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader)) {
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            objFilterMapUnknownEnumValues = obj;
                            while (i < this.repeatedFieldOffsetStart) {
                            }
                            if (objFilterMapUnknownEnumValues != null) {
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.MessageSchema$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i2, registers);
            case 15:
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint322;
            case 16:
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i3 = registers.int1;
        if (i3 < 0 || i3 > i2 - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i4 = iDecodeVarint32 + i3;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint32 < i4) {
            int iDecodeVarint322 = iDecodeVarint32 + 1;
            int i5 = bArr[iDecodeVarint32];
            if (i5 < 0) {
                iDecodeVarint322 = ArrayDecoders.decodeVarint32(i5, bArr, iDecodeVarint322, registers);
                i5 = registers.int1;
            }
            int i6 = iDecodeVarint322;
            int i7 = i5 >>> 3;
            int i8 = i5 & 7;
            if (i7 == 1) {
                if (i8 == metadata.keyType.getWireType()) {
                    iDecodeVarint32 = decodeMapEntryValue(bArr, i6, i2, metadata.keyType, null, registers);
                    obj = registers.object1;
                } else {
                    iDecodeVarint32 = ArrayDecoders.skipField(i5, bArr, i6, i2, registers);
                }
            } else if (i7 == 2 && i8 == metadata.valueType.getWireType()) {
                iDecodeVarint32 = decodeMapEntryValue(bArr, i6, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                obj2 = registers.object1;
            } else {
                iDecodeVarint32 = ArrayDecoders.skipField(i5, bArr, i6, i2, registers);
            }
        }
        if (iDecodeVarint32 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t, j2);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j2, protobufListMutableCopyWithCapacity2);
        }
        Internal.ProtobufList protobufList = protobufListMutableCopyWithCapacity2;
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 19:
            case 36:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 25:
            case 42:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufList, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 28:
                if (i5 == 2) {
                    return ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                    }
                    return i;
                }
                iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i4, (List<Integer>) protobufList, getEnumFieldVerifier(i6), unknownFieldSetLite, (UnknownFieldSchema<UT, UnknownFieldSetLite>) this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 34:
            case 48:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 49:
                if (i5 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            default:
                return i;
        }
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t, j, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws IOException {
        Object object;
        Unsafe unsafe = UNSAFE;
        long j2 = this.buffer[i8 + 2] & OFFSET_MASK;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                int i9 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                int i10 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i10;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(registers.long1));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint64;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(registers.int1));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint32;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                int i11 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                int i12 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i12;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint642;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i13 = registers.int1;
                if (i13 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint322, iDecodeVarint322 + i13)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t, j, new String(bArr, iDecodeVarint322, i13, Internal.UTF_8));
                    iDecodeVarint322 += i13;
                }
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint322;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i8), bArr, i, i2, registers);
                object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, registers.object1);
                } else {
                    unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                }
                unsafe.putInt(t, j2, i4);
                return iDecodeMessageField;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                unsafe.putObject(t, j, registers.object1);
                unsafe.putInt(t, j2, i4);
                return iDecodeBytes;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i14 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i8);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i14)) {
                    unsafe.putObject(t, j, Integer.valueOf(i14));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint323;
                }
                getMutableUnknownFields(t).storeField(i3, Long.valueOf(i14));
                return iDecodeVarint323;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint324;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint643;
            case 68:
                if (i5 == 3) {
                    int iDecodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i8), bArr, i, i2, (i3 & (-8)) | 4, registers);
                    object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, registers.object1);
                    } else {
                        unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iDecodeGroupField;
                }
                break;
        }
        return i;
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x008e. Please report as an issue. */
    int parseProto2Message(T t, byte[] bArr, int i, int i2, int i3, ArrayDecoders.Registers registers) throws IOException {
        T t2;
        Unsafe unsafe;
        MessageSchema<T> messageSchema;
        int iPositionForFieldNumber;
        int i4;
        int i5;
        int i6;
        ArrayDecoders.Registers registers2;
        int i7;
        int i8;
        T t3;
        int iDecodeUnknownField;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        T t4;
        Unsafe unsafe2;
        byte[] bArr2;
        int i17;
        Unsafe unsafe3;
        byte[] bArr3;
        int iDecodeVarint32;
        int i18;
        int i19;
        byte[] bArr4;
        int iDecodeMessageField;
        MessageSchema<T> messageSchema2 = this;
        T t5 = t;
        byte[] bArr5 = bArr;
        int i20 = i2;
        ArrayDecoders.Registers registers3 = registers;
        Unsafe unsafe4 = UNSAFE;
        int i21 = -1;
        int i22 = i;
        int i23 = -1;
        int i24 = 0;
        int i25 = -1;
        int i26 = 0;
        int i27 = 0;
        while (true) {
            if (i22 < i20) {
                int iDecodeVarint322 = i22 + 1;
                int i28 = bArr5[i22];
                if (i28 < 0) {
                    iDecodeVarint322 = ArrayDecoders.decodeVarint32(i28, bArr5, iDecodeVarint322, registers3);
                    i28 = registers3.int1;
                }
                int i29 = iDecodeVarint322;
                i27 = i28;
                int i30 = i27 >>> 3;
                int i31 = i27 & 7;
                if (i30 > i23) {
                    iPositionForFieldNumber = messageSchema2.positionForFieldNumber(i30, i24 / 3);
                } else {
                    iPositionForFieldNumber = messageSchema2.positionForFieldNumber(i30);
                }
                if (iPositionForFieldNumber == i21) {
                    i4 = i29;
                    unsafe = unsafe4;
                    i5 = i25;
                    i6 = i30;
                    registers2 = registers;
                    messageSchema = messageSchema2;
                    i7 = i27;
                    i8 = 0;
                } else {
                    int i32 = messageSchema2.buffer[iPositionForFieldNumber + 1];
                    int iType = type(i32);
                    int i33 = i25;
                    long jOffset = offset(i32);
                    if (iType <= 17) {
                        int i34 = messageSchema2.buffer[iPositionForFieldNumber + 2];
                        int i35 = 1 << (i34 >>> 20);
                        int i36 = i34 & OFFSET_MASK;
                        i6 = i30;
                        if (i36 != i33) {
                            i12 = iType;
                            if (i33 != -1) {
                                unsafe4.putInt(t5, i33, i26);
                            }
                            i13 = unsafe4.getInt(t5, i36);
                            i14 = i36;
                        } else {
                            i12 = iType;
                            i13 = i26;
                            i14 = i33;
                        }
                        switch (i12) {
                            case 0:
                                i15 = iPositionForFieldNumber;
                                i16 = i29;
                                registers2 = registers;
                                t4 = t5;
                                unsafe2 = unsafe4;
                                bArr2 = bArr;
                                if (i31 == 1) {
                                    UnsafeUtil.putDouble(t4, jOffset, ArrayDecoders.decodeDouble(bArr2, i16));
                                    i22 = i16 + 8;
                                    i17 = i13 | i35;
                                    i20 = i2;
                                    registers3 = registers2;
                                    i25 = i14;
                                    i24 = i15;
                                    i23 = i6;
                                    i26 = i17;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t5 = t4;
                                    i21 = -1;
                                    break;
                                } else {
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 1:
                                i15 = iPositionForFieldNumber;
                                i16 = i29;
                                registers2 = registers;
                                t4 = t5;
                                unsafe2 = unsafe4;
                                bArr2 = bArr;
                                if (i31 == 5) {
                                    UnsafeUtil.putFloat(t4, jOffset, ArrayDecoders.decodeFloat(bArr2, i16));
                                    i22 = i16 + 4;
                                    i17 = i13 | i35;
                                    i20 = i2;
                                    registers3 = registers2;
                                    i25 = i14;
                                    i24 = i15;
                                    i23 = i6;
                                    i26 = i17;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t5 = t4;
                                    i21 = -1;
                                    break;
                                } else {
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 2:
                            case 3:
                                i15 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i16 = i29;
                                bArr2 = bArr;
                                registers2 = registers;
                                if (i31 == 0) {
                                    int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i16, registers2);
                                    unsafe2 = unsafe3;
                                    unsafe2.putLong(t, jOffset, registers2.long1);
                                    t4 = t;
                                    i17 = i13 | i35;
                                    i20 = i2;
                                    i22 = iDecodeVarint64;
                                    registers3 = registers2;
                                    i25 = i14;
                                    i24 = i15;
                                    i23 = i6;
                                    i26 = i17;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t5 = t4;
                                    i21 = -1;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 4:
                            case 11:
                                i15 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i16 = i29;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i31 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr3, i16, registers2);
                                    unsafe3.putInt(t5, jOffset, registers2.int1);
                                    Unsafe unsafe5 = unsafe3;
                                    i22 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe5;
                                    registers3 = registers2;
                                    i25 = i14;
                                    i24 = i15;
                                    i23 = i6;
                                    i21 = -1;
                                    i26 = i13 | i35;
                                    i20 = i2;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 5:
                            case 14:
                                i15 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i31 == 1) {
                                    unsafe3.putLong(t, jOffset, ArrayDecoders.decodeFixed64(bArr3, i29));
                                    unsafe3 = unsafe3;
                                    t5 = t;
                                    iDecodeVarint32 = i29 + 8;
                                    Unsafe unsafe52 = unsafe3;
                                    i22 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe52;
                                    registers3 = registers2;
                                    i25 = i14;
                                    i24 = i15;
                                    i23 = i6;
                                    i21 = -1;
                                    i26 = i13 | i35;
                                    i20 = i2;
                                    break;
                                } else {
                                    i16 = i29;
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 6:
                            case 13:
                                i15 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i18 = i29;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i31 == 5) {
                                    unsafe3.putInt(t5, jOffset, ArrayDecoders.decodeFixed32(bArr3, i18));
                                    iDecodeVarint32 = i18 + 4;
                                    Unsafe unsafe522 = unsafe3;
                                    i22 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe522;
                                    registers3 = registers2;
                                    i25 = i14;
                                    i24 = i15;
                                    i23 = i6;
                                    i21 = -1;
                                    i26 = i13 | i35;
                                    i20 = i2;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i16 = i18;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 7:
                                i15 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i18 = i29;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i31 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint64(bArr3, i18, registers2);
                                    UnsafeUtil.putBoolean(t5, jOffset, registers2.long1 != 0);
                                    Unsafe unsafe5222 = unsafe3;
                                    i22 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe5222;
                                    registers3 = registers2;
                                    i25 = i14;
                                    i24 = i15;
                                    i23 = i6;
                                    i21 = -1;
                                    i26 = i13 | i35;
                                    i20 = i2;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i16 = i18;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 8:
                                i15 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i18 = i29;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i31 == 2) {
                                    if ((i32 & 536870912) == 0) {
                                        iDecodeVarint32 = ArrayDecoders.decodeString(bArr3, i18, registers2);
                                    } else {
                                        iDecodeVarint32 = ArrayDecoders.decodeStringRequireUtf8(bArr3, i18, registers2);
                                    }
                                    unsafe3.putObject(t5, jOffset, registers2.object1);
                                    Unsafe unsafe52222 = unsafe3;
                                    i22 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe52222;
                                    registers3 = registers2;
                                    i25 = i14;
                                    i24 = i15;
                                    i23 = i6;
                                    i21 = -1;
                                    i26 = i13 | i35;
                                    i20 = i2;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i16 = i18;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 9:
                                i19 = i20;
                                registers2 = registers;
                                i15 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i18 = i29;
                                bArr4 = bArr;
                                if (i31 == 2) {
                                    iDecodeMessageField = ArrayDecoders.decodeMessageField(messageSchema2.getMessageFieldSchema(i15), bArr4, i18, i19, registers2);
                                    if ((i13 & i35) == 0) {
                                        unsafe3.putObject(t5, jOffset, registers2.object1);
                                    } else {
                                        unsafe3.putObject(t5, jOffset, Internal.mergeMessage(unsafe3.getObject(t5, jOffset), registers2.object1));
                                    }
                                    Unsafe unsafe6 = unsafe3;
                                    i22 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe6;
                                    registers3 = registers2;
                                    i25 = i14;
                                    i24 = i15;
                                    i23 = i6;
                                    i26 = i13 | i35;
                                    i20 = i19;
                                    i21 = -1;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i16 = i18;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 10:
                                i19 = i20;
                                registers2 = registers;
                                i15 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i18 = i29;
                                bArr4 = bArr;
                                if (i31 == 2) {
                                    iDecodeMessageField = ArrayDecoders.decodeBytes(bArr4, i18, registers2);
                                    unsafe3.putObject(t5, jOffset, registers2.object1);
                                    Unsafe unsafe62 = unsafe3;
                                    i22 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe62;
                                    registers3 = registers2;
                                    i25 = i14;
                                    i24 = i15;
                                    i23 = i6;
                                    i26 = i13 | i35;
                                    i20 = i19;
                                    i21 = -1;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i16 = i18;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 12:
                                i15 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i18 = i29;
                                bArr4 = bArr;
                                registers2 = registers;
                                i19 = i20;
                                if (i31 != 0) {
                                    unsafe2 = unsafe3;
                                    i16 = i18;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                } else {
                                    iDecodeMessageField = ArrayDecoders.decodeVarint32(bArr4, i18, registers2);
                                    int i37 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i15);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i37)) {
                                        unsafe3.putInt(t5, jOffset, i37);
                                        Unsafe unsafe622 = unsafe3;
                                        i22 = iDecodeMessageField;
                                        bArr5 = bArr4;
                                        unsafe4 = unsafe622;
                                        registers3 = registers2;
                                        i25 = i14;
                                        i24 = i15;
                                        i23 = i6;
                                        i26 = i13 | i35;
                                        i20 = i19;
                                        i21 = -1;
                                        break;
                                    } else {
                                        getMutableUnknownFields(t5).storeField(i27, Long.valueOf(i37));
                                        i22 = iDecodeMessageField;
                                        bArr5 = bArr4;
                                        unsafe4 = unsafe3;
                                        i20 = i19;
                                        registers3 = registers2;
                                        i25 = i14;
                                        i26 = i13;
                                        i24 = i15;
                                        i23 = i6;
                                        i21 = -1;
                                    }
                                }
                                break;
                            case 15:
                                i15 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i18 = i29;
                                bArr4 = bArr;
                                registers2 = registers;
                                i19 = i20;
                                if (i31 == 0) {
                                    iDecodeMessageField = ArrayDecoders.decodeVarint32(bArr4, i18, registers2);
                                    unsafe3.putInt(t5, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    Unsafe unsafe6222 = unsafe3;
                                    i22 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe6222;
                                    registers3 = registers2;
                                    i25 = i14;
                                    i24 = i15;
                                    i23 = i6;
                                    i26 = i13 | i35;
                                    i20 = i19;
                                    i21 = -1;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i16 = i18;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 16:
                                i15 = iPositionForFieldNumber;
                                i18 = i29;
                                if (i31 == 0) {
                                    int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i18, registers);
                                    T t6 = t5;
                                    Unsafe unsafe7 = unsafe4;
                                    unsafe7.putLong(t6, jOffset, CodedInputStream.decodeZigZag64(registers.long1));
                                    t5 = t6;
                                    int i38 = i14;
                                    i26 = i13 | i35;
                                    bArr5 = bArr;
                                    unsafe4 = unsafe7;
                                    i22 = iDecodeVarint642;
                                    registers3 = registers;
                                    i25 = i38;
                                    i20 = i2;
                                    i24 = i15;
                                    i23 = i6;
                                    i21 = -1;
                                    break;
                                } else {
                                    unsafe3 = unsafe4;
                                    registers2 = registers;
                                    unsafe2 = unsafe3;
                                    i16 = i18;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            case 17:
                                if (i31 == 3) {
                                    int i39 = iPositionForFieldNumber;
                                    int iDecodeGroupField = ArrayDecoders.decodeGroupField(messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), bArr, i29, i20, (i6 << 3) | 4, registers);
                                    if ((i13 & i35) == 0) {
                                        unsafe4.putObject(t5, jOffset, registers.object1);
                                    } else {
                                        unsafe4.putObject(t5, jOffset, Internal.mergeMessage(unsafe4.getObject(t5, jOffset), registers.object1));
                                    }
                                    i22 = iDecodeGroupField;
                                    bArr5 = bArr;
                                    registers3 = registers;
                                    i25 = i14;
                                    i24 = i39;
                                    i21 = -1;
                                    i20 = i2;
                                    i26 = i13 | i35;
                                    i23 = i6;
                                    break;
                                } else {
                                    i15 = iPositionForFieldNumber;
                                    registers2 = registers;
                                    unsafe2 = unsafe4;
                                    i16 = i29;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i4 = i16;
                                    i5 = i14;
                                    i7 = i27;
                                    i26 = i13;
                                    i8 = i15;
                                    break;
                                }
                            default:
                                registers2 = registers;
                                i15 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                i16 = i29;
                                messageSchema = messageSchema2;
                                unsafe = unsafe2;
                                i4 = i16;
                                i5 = i14;
                                i7 = i27;
                                i26 = i13;
                                i8 = i15;
                                break;
                        }
                    } else {
                        int i40 = iPositionForFieldNumber;
                        i6 = i30;
                        T t7 = t5;
                        Unsafe unsafe8 = unsafe4;
                        i5 = i33;
                        if (iType == 27) {
                            if (i31 == 2) {
                                Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe8.getObject(t7, jOffset);
                                if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                    int size = protobufListMutableCopyWithCapacity2.size();
                                    protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                    unsafe8.putObject(t7, jOffset, protobufListMutableCopyWithCapacity2);
                                }
                                unsafe4 = unsafe8;
                                int iDecodeMessageList = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(i40), i27, bArr, i29, i2, protobufListMutableCopyWithCapacity2, registers);
                                bArr5 = bArr;
                                i20 = i2;
                                registers3 = registers;
                                i22 = iDecodeMessageList;
                                t5 = t7;
                                i24 = i40;
                                i23 = i6;
                                i25 = i5;
                                i21 = -1;
                            } else {
                                unsafe = unsafe8;
                                i11 = i29;
                                i9 = i26;
                                i10 = i27;
                                i8 = i40;
                                messageSchema = this;
                                registers2 = registers;
                                i4 = i11;
                                i7 = i10;
                            }
                        } else if (iType <= 49) {
                            unsafe = unsafe8;
                            i9 = i26;
                            int repeatedField = messageSchema2.parseRepeatedField(t, bArr, i29, i2, i27, i6, i31, i40, i32, iType, jOffset, registers);
                            i10 = i27;
                            i8 = i40;
                            if (repeatedField != i29) {
                                messageSchema2 = this;
                                t5 = t;
                                bArr5 = bArr;
                                i20 = i2;
                                i22 = repeatedField;
                                i24 = i8;
                                i26 = i9;
                                i23 = i6;
                                i25 = i5;
                                unsafe4 = unsafe;
                                registers3 = registers;
                                i27 = i10;
                                i21 = -1;
                            } else {
                                messageSchema = this;
                                registers2 = registers;
                                i4 = repeatedField;
                                i7 = i10;
                            }
                        } else {
                            unsafe = unsafe8;
                            i9 = i26;
                            i10 = i27;
                            i8 = i40;
                            i11 = i29;
                            if (iType != 50) {
                                int oneofField = parseOneofField(t, bArr, i11, i2, i10, i6, i31, i32, iType, jOffset, i8, registers);
                                messageSchema = this;
                                i7 = i10;
                                registers2 = registers;
                                if (oneofField != i11) {
                                    t5 = t;
                                    bArr5 = bArr;
                                    i20 = i2;
                                    i22 = oneofField;
                                    registers3 = registers2;
                                    i24 = i8;
                                    i26 = i9;
                                    i23 = i6;
                                    i25 = i5;
                                    i21 = -1;
                                    i27 = i7;
                                    messageSchema2 = messageSchema;
                                    unsafe4 = unsafe;
                                } else {
                                    i4 = oneofField;
                                }
                            } else if (i31 == 2) {
                                int mapField = parseMapField(t, bArr, i11, i2, i8, jOffset, registers);
                                if (mapField != i11) {
                                    messageSchema2 = this;
                                    t5 = t;
                                    bArr5 = bArr;
                                    i20 = i2;
                                    registers3 = registers;
                                    i22 = mapField;
                                    i24 = i8;
                                    i26 = i9;
                                    i23 = i6;
                                    i25 = i5;
                                    unsafe4 = unsafe;
                                    i27 = i10;
                                    i21 = -1;
                                } else {
                                    messageSchema = this;
                                    registers2 = registers;
                                    i4 = mapField;
                                    i7 = i10;
                                }
                            } else {
                                messageSchema = this;
                                registers2 = registers;
                                i4 = i11;
                                i7 = i10;
                            }
                        }
                        i26 = i9;
                    }
                }
                if (i7 != i3 || i3 == 0) {
                    if (messageSchema.hasExtensions && registers2.extensionRegistry != ExtensionRegistryLite.getEmptyRegistry()) {
                        iDecodeUnknownField = ArrayDecoders.decodeExtensionOrUnknownField(i7, bArr, i4, i2, t, messageSchema.defaultInstance, messageSchema.unknownFieldSchema, registers2);
                        t3 = t;
                        i20 = i2;
                    } else {
                        t3 = t;
                        iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i7, bArr, i4, i2, getMutableUnknownFields(t3), registers);
                        i20 = i2;
                    }
                    i22 = iDecodeUnknownField;
                    bArr5 = bArr;
                    registers3 = registers;
                    t5 = t3;
                    i24 = i8;
                    i23 = i6;
                    i25 = i5;
                    i21 = -1;
                    i27 = i7;
                    messageSchema2 = messageSchema;
                    unsafe4 = unsafe;
                } else {
                    t2 = t;
                    i20 = i2;
                    i27 = i7;
                    i22 = i4;
                    i25 = i5;
                }
            } else {
                t2 = t5;
                unsafe = unsafe4;
                messageSchema = messageSchema2;
            }
        }
        if (i25 != -1) {
            unsafe.putInt(t2, i25, i26);
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i41 = messageSchema.checkInitializedCount; i41 < messageSchema.repeatedFieldOffsetStart; i41++) {
            unknownFieldSetLite = (UnknownFieldSetLite) messageSchema.filterMapUnknownEnumValues(t2, messageSchema.intArray[i41], unknownFieldSetLite, messageSchema.unknownFieldSchema);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t2, unknownFieldSetLite);
        }
        if (i3 == 0) {
            if (i22 != i20) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i22 > i20 || i27 != i3) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i22;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0050. Please report as an issue. */
    private int parseProto3Message(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        int iPositionForFieldNumber;
        Unsafe unsafe;
        int i3;
        int i4;
        int i5;
        Unsafe unsafe2;
        int iDecodeVarint64;
        int i6;
        int i7;
        int i8;
        MessageSchema<T> messageSchema = this;
        byte[] bArr2 = bArr;
        int i9 = i2;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe3 = UNSAFE;
        int i10 = -1;
        int iDecodeUnknownField = i;
        int i11 = -1;
        int i12 = 0;
        while (iDecodeUnknownField < i9) {
            int iDecodeVarint32 = iDecodeUnknownField + 1;
            int i13 = bArr2[iDecodeUnknownField];
            if (i13 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(i13, bArr2, iDecodeVarint32, registers2);
                i13 = registers2.int1;
            }
            int i14 = iDecodeVarint32;
            int i15 = i13;
            int i16 = i15 >>> 3;
            int i17 = i15 & 7;
            if (i16 > i11) {
                iPositionForFieldNumber = messageSchema.positionForFieldNumber(i16, i12 / 3);
            } else {
                iPositionForFieldNumber = messageSchema.positionForFieldNumber(i16);
            }
            int i18 = iPositionForFieldNumber;
            if (i18 == i10) {
                unsafe = unsafe3;
                i3 = i14;
                i4 = i16;
                i18 = 0;
            } else {
                int i19 = messageSchema.buffer[i18 + 1];
                int iType = type(i19);
                long jOffset = offset(i19);
                if (iType <= 17) {
                    switch (iType) {
                        case 0:
                            i5 = i15;
                            if (i17 == 1) {
                                UnsafeUtil.putDouble(t, jOffset, ArrayDecoders.decodeDouble(bArr2, i14));
                                iDecodeUnknownField = i14 + 8;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                            unsafe = unsafe3;
                            i6 = i14;
                            i7 = i16;
                            i8 = i5;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                        case 1:
                            i5 = i15;
                            if (i17 == 5) {
                                UnsafeUtil.putFloat(t, jOffset, ArrayDecoders.decodeFloat(bArr2, i14));
                                iDecodeUnknownField = i14 + 4;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                            unsafe = unsafe3;
                            i6 = i14;
                            i7 = i16;
                            i8 = i5;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                        case 2:
                        case 3:
                            i5 = i15;
                            unsafe2 = unsafe3;
                            if (i17 != 0) {
                                unsafe = unsafe2;
                                i6 = i14;
                                i7 = i16;
                                i8 = i5;
                                i3 = i6;
                                i4 = i7;
                                i15 = i8;
                                break;
                            } else {
                                iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i14, registers2);
                                unsafe3 = unsafe2;
                                unsafe3.putLong(t, jOffset, registers2.long1);
                                iDecodeUnknownField = iDecodeVarint64;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                        case 4:
                        case 11:
                            i5 = i15;
                            unsafe2 = unsafe3;
                            if (i17 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i14, registers2);
                                unsafe2.putInt(t, jOffset, registers2.int1);
                                unsafe3 = unsafe2;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                            unsafe = unsafe2;
                            i6 = i14;
                            i7 = i16;
                            i8 = i5;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                        case 5:
                        case 14:
                            i5 = i15;
                            unsafe2 = unsafe3;
                            if (i17 == 1) {
                                unsafe2.putLong(t, jOffset, ArrayDecoders.decodeFixed64(bArr2, i14));
                                unsafe2 = unsafe2;
                                iDecodeUnknownField = i14 + 8;
                                unsafe3 = unsafe2;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                            unsafe = unsafe2;
                            i6 = i14;
                            i7 = i16;
                            i8 = i5;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                        case 6:
                        case 13:
                            i5 = i15;
                            unsafe2 = unsafe3;
                            if (i17 == 5) {
                                unsafe2.putInt(t, jOffset, ArrayDecoders.decodeFixed32(bArr2, i14));
                                iDecodeUnknownField = i14 + 4;
                                unsafe3 = unsafe2;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                            unsafe = unsafe2;
                            i6 = i14;
                            i7 = i16;
                            i8 = i5;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                        case 7:
                            i5 = i15;
                            unsafe2 = unsafe3;
                            if (i17 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr2, i14, registers2);
                                UnsafeUtil.putBoolean(t, jOffset, registers2.long1 != 0);
                                unsafe3 = unsafe2;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                            unsafe = unsafe2;
                            i6 = i14;
                            i7 = i16;
                            i8 = i5;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                        case 8:
                            i5 = i15;
                            unsafe2 = unsafe3;
                            if (i17 == 2) {
                                if ((536870912 & i19) == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeString(bArr2, i14, registers2);
                                } else {
                                    iDecodeUnknownField = ArrayDecoders.decodeStringRequireUtf8(bArr2, i14, registers2);
                                }
                                unsafe2.putObject(t, jOffset, registers2.object1);
                                unsafe3 = unsafe2;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                            unsafe = unsafe2;
                            i6 = i14;
                            i7 = i16;
                            i8 = i5;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                        case 9:
                            i5 = i15;
                            unsafe2 = unsafe3;
                            if (i17 == 2) {
                                iDecodeUnknownField = ArrayDecoders.decodeMessageField(messageSchema.getMessageFieldSchema(i18), bArr2, i14, i9, registers2);
                                Object object = unsafe2.getObject(t, jOffset);
                                if (object == null) {
                                    unsafe2.putObject(t, jOffset, registers2.object1);
                                } else {
                                    unsafe2.putObject(t, jOffset, Internal.mergeMessage(object, registers2.object1));
                                }
                                unsafe3 = unsafe2;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                            unsafe = unsafe2;
                            i6 = i14;
                            i7 = i16;
                            i8 = i5;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                        case 10:
                            i5 = i15;
                            unsafe2 = unsafe3;
                            if (i17 == 2) {
                                iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr2, i14, registers2);
                                unsafe2.putObject(t, jOffset, registers2.object1);
                                unsafe3 = unsafe2;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                            unsafe = unsafe2;
                            i6 = i14;
                            i7 = i16;
                            i8 = i5;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                        case 12:
                            unsafe2 = unsafe3;
                            if (i17 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i14, registers2);
                                unsafe2.putInt(t, jOffset, registers2.int1);
                                unsafe3 = unsafe2;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                            unsafe = unsafe2;
                            i6 = i14;
                            i7 = i16;
                            i8 = i15;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                        case 15:
                            unsafe2 = unsafe3;
                            if (i17 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i14, registers2);
                                unsafe2.putInt(t, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                unsafe3 = unsafe2;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                            unsafe = unsafe2;
                            i6 = i14;
                            i7 = i16;
                            i8 = i15;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                        case 16:
                            if (i17 != 0) {
                                unsafe2 = unsafe3;
                                unsafe = unsafe2;
                                i6 = i14;
                                i7 = i16;
                                i8 = i15;
                                i3 = i6;
                                i4 = i7;
                                i15 = i8;
                                break;
                            } else {
                                iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i14, registers2);
                                unsafe3.putLong(t, jOffset, CodedInputStream.decodeZigZag64(registers2.long1));
                                unsafe3 = unsafe3;
                                iDecodeUnknownField = iDecodeVarint64;
                                i11 = i16;
                                i12 = i18;
                                break;
                            }
                        default:
                            unsafe = unsafe3;
                            i6 = i14;
                            i7 = i16;
                            i8 = i15;
                            i3 = i6;
                            i4 = i7;
                            i15 = i8;
                            break;
                    }
                } else {
                    i5 = i15;
                    if (iType == 27) {
                        if (i17 == 2) {
                            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe3.getObject(t, jOffset);
                            if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                int size = protobufListMutableCopyWithCapacity2.size();
                                protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe3.putObject(t, jOffset, protobufListMutableCopyWithCapacity2);
                            }
                            unsafe = unsafe3;
                            iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema.getMessageFieldSchema(i18), i5, bArr2, i14, i9, protobufListMutableCopyWithCapacity2, registers2);
                            bArr2 = bArr;
                            i9 = i2;
                            registers2 = registers;
                            i11 = i16;
                        }
                        unsafe = unsafe3;
                        i6 = i14;
                        i7 = i16;
                        i8 = i5;
                        i3 = i6;
                        i4 = i7;
                        i15 = i8;
                    } else {
                        unsafe = unsafe3;
                        if (iType <= 49) {
                            int repeatedField = messageSchema.parseRepeatedField(t, bArr, i14, i2, i5, i16, i17, i18, i19, iType, jOffset, registers);
                            i8 = i5;
                            i7 = i16;
                            i18 = i18;
                            if (repeatedField != i14) {
                                messageSchema = this;
                                i9 = i2;
                                registers2 = registers;
                                iDecodeUnknownField = repeatedField;
                                i11 = i7;
                                i12 = i18;
                                unsafe3 = unsafe;
                                i10 = -1;
                                bArr2 = bArr;
                            } else {
                                i3 = repeatedField;
                                i4 = i7;
                                i15 = i8;
                            }
                        } else {
                            i7 = i16;
                            i8 = i5;
                            i6 = i14;
                            if (iType == 50) {
                                if (i17 == 2) {
                                    int mapField = parseMapField(t, bArr, i6, i2, i18, jOffset, registers);
                                    if (mapField != i6) {
                                        messageSchema = this;
                                        bArr2 = bArr;
                                        i9 = i2;
                                        registers2 = registers;
                                        iDecodeUnknownField = mapField;
                                        i11 = i7;
                                    } else {
                                        i3 = mapField;
                                    }
                                } else {
                                    i3 = i6;
                                }
                                i4 = i7;
                                i15 = i8;
                            } else {
                                i4 = i7;
                                i15 = i8;
                                int oneofField = parseOneofField(t, bArr, i6, i2, i15, i4, i17, i19, iType, jOffset, i18, registers);
                                if (oneofField != i6) {
                                    messageSchema = this;
                                    i9 = i2;
                                    registers2 = registers;
                                    i11 = i4;
                                    iDecodeUnknownField = oneofField;
                                    i12 = i18;
                                    unsafe3 = unsafe;
                                    i10 = -1;
                                    bArr2 = bArr;
                                } else {
                                    i3 = oneofField;
                                }
                            }
                        }
                    }
                    i12 = i18;
                    unsafe3 = unsafe;
                }
                i10 = -1;
            }
            iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i15, bArr, i3, i2, getMutableUnknownFields(t), registers);
            messageSchema = this;
            bArr2 = bArr;
            registers2 = registers;
            i9 = i2;
            i11 = i4;
            i12 = i18;
            unsafe3 = unsafe;
            i10 = -1;
        }
        if (iDecodeUnknownField == i9) {
            return iDecodeUnknownField;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t, bArr, i, i2, registers);
        } else {
            parseProto2Message(t, bArr, i, i2, 0, registers);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void makeImmutable(T t) {
        int i;
        int i2 = this.checkInitializedCount;
        while (true) {
            i = this.repeatedFieldOffsetStart;
            if (i2 >= i) {
                break;
            }
            long jOffset = offset(typeAndOffsetAt(this.intArray[i2]));
            Object object = UnsafeUtil.getObject(t, jOffset);
            if (object != null) {
                UnsafeUtil.putObject(t, jOffset, this.mapFieldSchema.toImmutable(object));
            }
            i2++;
        }
        int length = this.intArray.length;
        while (i < length) {
            this.listFieldSchema.makeImmutableListAt(t, this.intArray[i]);
            i++;
        }
        this.unknownFieldSchema.makeImmutable(t);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t);
        }
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long jOffset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.newBuilder();
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isInitialized(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < this.checkInitializedCount; i4++) {
            int i5 = this.intArray[i4];
            int iNumberAt = numberAt(i5);
            int iTypeAndOffsetAt = typeAndOffsetAt(i5);
            if (this.proto3) {
                i = 0;
            } else {
                int i6 = this.buffer[i5 + 2];
                int i7 = OFFSET_MASK & i6;
                i = 1 << (i6 >>> 20);
                if (i7 != i2) {
                    i3 = UNSAFE.getInt(t, i7);
                    i2 = i7;
                }
            }
            if (isRequired(iTypeAndOffsetAt) && !isFieldPresent(t, i5, i3, i)) {
                return false;
            }
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (isFieldPresent(t, i5, i3, i) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i5))) {
                    return false;
                }
            } else if (iType == 27) {
                if (!isListInitialized(t, iTypeAndOffsetAt, i5)) {
                    return false;
                }
            } else if (iType == 60 || iType == 68) {
                if (isOneofPresent(t, iNumberAt, i5) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i5))) {
                    return false;
                }
            } else if (iType != 49) {
                if (iType == 50 && !isMapInitialized(t, iTypeAndOffsetAt, i5)) {
                    return false;
                }
            }
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.crypto.tink.shaded.protobuf.Schema] */
    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            SchemaFor = SchemaFor;
            if (SchemaFor == 0) {
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private void readString(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble(t, j);
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat(t, j);
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt(t, j);
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong(t, j);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean(t, j);
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject(t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject(t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject(t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject(t, j)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject(t, j)).booleanValue();
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3) {
        if (this.proto3) {
            return isFieldPresent(t, i);
        }
        return (i2 & i3) != 0;
    }

    private boolean isFieldPresent(T t, int i) {
        if (this.proto3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            long jOffset = offset(iTypeAndOffsetAt);
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    return UnsafeUtil.getDouble(t, jOffset) != 0.0d;
                case 1:
                    return UnsafeUtil.getFloat(t, jOffset) != 0.0f;
                case 2:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 3:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 4:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 5:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 6:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 7:
                    return UnsafeUtil.getBoolean(t, jOffset);
                case 8:
                    Object object = UnsafeUtil.getObject(t, jOffset);
                    if (object instanceof String) {
                        return !((String) object).isEmpty();
                    }
                    if (object instanceof ByteString) {
                        return !ByteString.EMPTY.equals(object);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return UnsafeUtil.getObject(t, jOffset) != null;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t, jOffset));
                case 11:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 12:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 13:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 14:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 15:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 16:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 17:
                    return UnsafeUtil.getObject(t, jOffset) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        return (UnsafeUtil.getInt(t, (long) (iPresenceMaskAndOffsetAt & OFFSET_MASK)) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
    }

    private void setFieldPresent(T t, int i) {
        if (this.proto3) {
            return;
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = iPresenceMaskAndOffsetAt & OFFSET_MASK;
        UnsafeUtil.putInt(t, j, UnsafeUtil.getInt(t, j) | (1 << (iPresenceMaskAndOffsetAt >>> 20)));
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & OFFSET_MASK)) == i;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & OFFSET_MASK;
        return UnsafeUtil.getInt(t, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, jPresenceMaskAndOffsetAt);
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt(t, presenceMaskAndOffsetAt(i2) & OFFSET_MASK, i);
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iNumberAt = numberAt(i4);
            if (i == iNumberAt) {
                return i4;
            }
            if (i < iNumberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
