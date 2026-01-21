package org.spongycastle.x509;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.x509.AccessDescription;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.AuthorityInformationAccess;
import org.spongycastle.asn1.x509.AuthorityKeyIdentifier;
import org.spongycastle.asn1.x509.BasicConstraints;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.GeneralSubtree;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;
import org.spongycastle.asn1.x509.NameConstraints;
import org.spongycastle.asn1.x509.PolicyInformation;
import org.spongycastle.asn1.x509.qualified.MonetaryValue;
import org.spongycastle.asn1.x509.qualified.QCStatement;
import org.spongycastle.i18n.ErrorBundle;
import org.spongycastle.i18n.LocaleString;
import org.spongycastle.i18n.filter.TrustedInput;
import org.spongycastle.i18n.filter.UntrustedInput;
import org.spongycastle.i18n.filter.UntrustedUrlInput;
import org.spongycastle.jce.provider.AnnotatedException;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.PKIXNameConstraintValidator;
import org.spongycastle.jce.provider.PKIXNameConstraintValidatorException;
import org.spongycastle.jce.provider.PKIXPolicyNode;
import org.spongycastle.util.Integers;

/* loaded from: classes6.dex */
public class PKIXCertPathReviewer extends CertPathValidatorUtilities {
    private static final String RESOURCE_NAME = "org.spongycastle.x509.CertPathReviewerMessages";
    protected CertPath certPath;
    protected List certs;
    protected List[] errors;
    private boolean initialized;
    protected int n;
    protected List[] notifications;
    protected PKIXParameters pkixParams;
    protected PolicyNode policyTree;
    protected PublicKey subjectPublicKey;
    protected TrustAnchor trustAnchor;
    protected Date validDate;
    private static final String QC_STATEMENT = Extension.qCStatements.getId();
    private static final String CRL_DIST_POINTS = Extension.cRLDistributionPoints.getId();
    private static final String AUTH_INFO_ACCESS = Extension.authorityInfoAccess.getId();

    public void init(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        if (this.initialized) {
            throw new IllegalStateException("object is already initialized!");
        }
        this.initialized = true;
        if (certPath == null) {
            throw new NullPointerException("certPath was null");
        }
        this.certPath = certPath;
        List<? extends Certificate> certificates = certPath.getCertificates();
        this.certs = certificates;
        this.n = certificates.size();
        if (this.certs.isEmpty()) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.emptyCertPath"));
        }
        PKIXParameters pKIXParameters2 = (PKIXParameters) pKIXParameters.clone();
        this.pkixParams = pKIXParameters2;
        this.validDate = getValidDate(pKIXParameters2);
        this.notifications = null;
        this.errors = null;
        this.trustAnchor = null;
        this.subjectPublicKey = null;
        this.policyTree = null;
    }

    public PKIXCertPathReviewer(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        init(certPath, pKIXParameters);
    }

    public PKIXCertPathReviewer() {
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getCertPathSize() {
        return this.n;
    }

    public List[] getErrors() throws Exception {
        doChecks();
        return this.errors;
    }

    public List getErrors(int i) throws Exception {
        doChecks();
        return this.errors[i + 1];
    }

    public List[] getNotifications() throws Exception {
        doChecks();
        return this.notifications;
    }

    public List getNotifications(int i) throws Exception {
        doChecks();
        return this.notifications[i + 1];
    }

    public PolicyNode getPolicyTree() throws Exception {
        doChecks();
        return this.policyTree;
    }

    public PublicKey getSubjectPublicKey() throws Exception {
        doChecks();
        return this.subjectPublicKey;
    }

    public TrustAnchor getTrustAnchor() throws Exception {
        doChecks();
        return this.trustAnchor;
    }

    public boolean isValidCertPath() throws Exception {
        doChecks();
        int i = 0;
        while (true) {
            List[] listArr = this.errors;
            if (i >= listArr.length) {
                return true;
            }
            if (!listArr[i].isEmpty()) {
                return false;
            }
            i++;
        }
    }

    protected void addNotification(ErrorBundle errorBundle) {
        this.notifications[0].add(errorBundle);
    }

    protected void addNotification(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.notifications[i + 1].add(errorBundle);
    }

    protected void addError(ErrorBundle errorBundle) {
        this.errors[0].add(errorBundle);
    }

    protected void addError(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.errors[i + 1].add(errorBundle);
    }

    protected void doChecks() throws Exception {
        if (!this.initialized) {
            throw new IllegalStateException("Object not initialized. Call init() first.");
        }
        if (this.notifications != null) {
            return;
        }
        int i = this.n;
        this.notifications = new List[i + 1];
        this.errors = new List[i + 1];
        int i2 = 0;
        while (true) {
            List[] listArr = this.notifications;
            if (i2 < listArr.length) {
                listArr[i2] = new ArrayList();
                this.errors[i2] = new ArrayList();
                i2++;
            } else {
                checkSignatures();
                checkNameConstraints();
                checkPathLength();
                checkPolicy();
                checkCriticalExtensions();
                return;
            }
        }
    }

    private void checkNameConstraints() throws CertPathReviewerException {
        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
        try {
            for (int size = this.certs.size() - 1; size > 0; size--) {
                X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
                if (!isSelfIssued(x509Certificate)) {
                    X500Principal subjectPrincipal = getSubjectPrincipal(x509Certificate);
                    try {
                        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(new ByteArrayInputStream(subjectPrincipal.getEncoded())).readObject();
                        try {
                            pKIXNameConstraintValidator.checkPermittedDN(aSN1Sequence);
                            try {
                                pKIXNameConstraintValidator.checkExcludedDN(aSN1Sequence);
                                try {
                                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) getExtensionValue(x509Certificate, SUBJECT_ALTERNATIVE_NAME);
                                    if (aSN1Sequence2 != null) {
                                        for (int i = 0; i < aSN1Sequence2.size(); i++) {
                                            GeneralName generalName = GeneralName.getInstance(aSN1Sequence2.getObjectAt(i));
                                            try {
                                                pKIXNameConstraintValidator.checkPermitted(generalName);
                                                pKIXNameConstraintValidator.checkExcluded(generalName);
                                            } catch (PKIXNameConstraintValidatorException e) {
                                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedEmail", new Object[]{new UntrustedInput(generalName)}), e, this.certPath, size);
                                            }
                                        }
                                    }
                                } catch (AnnotatedException e2) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.subjAltNameExtError"), e2, this.certPath, size);
                                }
                            } catch (PKIXNameConstraintValidatorException e3) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.excludedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e3, this.certPath, size);
                            }
                        } catch (PKIXNameConstraintValidatorException e4) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e4, this.certPath, size);
                        }
                    } catch (IOException e5) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncSubjectNameError", new Object[]{new UntrustedInput(subjectPrincipal)}), e5, this.certPath, size);
                    }
                }
                try {
                    ASN1Sequence aSN1Sequence3 = (ASN1Sequence) getExtensionValue(x509Certificate, NAME_CONSTRAINTS);
                    if (aSN1Sequence3 != null) {
                        NameConstraints nameConstraints = NameConstraints.getInstance(aSN1Sequence3);
                        GeneralSubtree[] permittedSubtrees = nameConstraints.getPermittedSubtrees();
                        if (permittedSubtrees != null) {
                            pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                        }
                        GeneralSubtree[] excludedSubtrees = nameConstraints.getExcludedSubtrees();
                        if (excludedSubtrees != null) {
                            for (int i2 = 0; i2 != excludedSubtrees.length; i2++) {
                                pKIXNameConstraintValidator.addExcludedSubtree(excludedSubtrees[i2]);
                            }
                        }
                    }
                } catch (AnnotatedException e6) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncExtError"), e6, this.certPath, size);
                }
            }
        } catch (CertPathReviewerException e7) {
            addError(e7.getErrorMessage(), e7.getIndex());
        }
    }

    private void checkPathLength() {
        BasicConstraints basicConstraints;
        BigInteger pathLenConstraint;
        int iIntValue;
        int i = this.n;
        int i2 = 0;
        for (int size = this.certs.size() - 1; size > 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            if (!isSelfIssued(x509Certificate)) {
                if (i <= 0) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.pathLengthExtended"));
                }
                i--;
                i2++;
            }
            try {
                basicConstraints = BasicConstraints.getInstance(getExtensionValue(x509Certificate, BASIC_CONSTRAINTS));
            } catch (AnnotatedException unused) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.processLengthConstError"), size);
                basicConstraints = null;
            }
            if (basicConstraints != null && (pathLenConstraint = basicConstraints.getPathLenConstraint()) != null && (iIntValue = pathLenConstraint.intValue()) < i) {
                i = iIntValue;
            }
        }
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.totalPathLength", new Object[]{Integers.valueOf(i2)}));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:56|(3:163|58|59)(2:63|(2:159|65)(14:69|(2:76|77)(3:73|(1:75)(0)|77)|173|78|82|(19:161|84|(1:86)(1:89)|171|90|(1:92)(1:95)|96|(2:99|97)|183|100|(2:103|101)|167|104|105|157|106|107|155|108)(1:117)|(1:122)(1:121)|123|(7:125|(1:129)|169|130|(2:132|(1:134))(1:135)|138|(1:142))|143|165|144|182|147))|62|173|78|82|(0)(0)|(2:119|122)(0)|123|(0)|143|165|144|182|147) */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x03cf, code lost:
    
        addError(new org.spongycastle.i18n.ErrorBundle(org.spongycastle.x509.PKIXCertPathReviewer.RESOURCE_NAME, "CertPathReviewer.pubKeyError"), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0261, code lost:
    
        r8 = new java.lang.Object[1];
        r8[r17] = new org.spongycastle.i18n.filter.TrustedInput(r4.getNotAfter());
        addError(new org.spongycastle.i18n.ErrorBundle(org.spongycastle.x509.PKIXCertPathReviewer.RESOURCE_NAME, "CertPathReviewer.certificateExpired", r8), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0279, code lost:
    
        r8 = new java.lang.Object[1];
        r8[r17] = new org.spongycastle.i18n.filter.TrustedInput(r4.getNotBefore());
        addError(new org.spongycastle.i18n.ErrorBundle(org.spongycastle.x509.PKIXCertPathReviewer.RESOURCE_NAME, "CertPathReviewer.certificateNotYetValid", r8), r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0298 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0256  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkSignatures() throws Exception {
        TrustAnchor trustAnchor;
        TrustAnchor trustAnchor2;
        X500Principal subjectX500Principal;
        X509Certificate trustedCert;
        PublicKey cAPublicKey;
        int size;
        char c;
        X500Principal x500Principal;
        int i;
        X509Certificate x509Certificate;
        ASN1Primitive extensionValue;
        ASN1Primitive extensionValue2;
        AuthorityKeyIdentifier authorityKeyIdentifier;
        GeneralNames authorityCertIssuer;
        boolean[] keyUsage;
        X509Certificate x509Certificate2;
        Collection trustAnchors;
        PublicKey cAPublicKey2;
        char c2 = 2;
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathValidDate", new Object[]{new TrustedInput(this.validDate), new TrustedInput(new Date())}));
        try {
            List list = this.certs;
            x509Certificate2 = (X509Certificate) list.get(list.size() - 1);
            trustAnchors = getTrustAnchors(x509Certificate2, this.pkixParams.getTrustAnchors());
        } catch (CertPathReviewerException e) {
            e = e;
            trustAnchor = null;
        } catch (Throwable th) {
            th = th;
            trustAnchor = null;
        }
        if (trustAnchors.size() > 1) {
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.conflictingTrustAnchors", new Object[]{Integers.valueOf(trustAnchors.size()), new UntrustedInput(x509Certificate2.getIssuerX500Principal())}));
        } else if (trustAnchors.isEmpty()) {
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noTrustAnchorFound", new Object[]{new UntrustedInput(x509Certificate2.getIssuerX500Principal()), Integers.valueOf(this.pkixParams.getTrustAnchors().size())}));
        } else {
            trustAnchor = (TrustAnchor) trustAnchors.iterator().next();
            try {
                if (trustAnchor.getTrustedCert() != null) {
                    cAPublicKey2 = trustAnchor.getTrustedCert().getPublicKey();
                } else {
                    cAPublicKey2 = trustAnchor.getCAPublicKey();
                }
                try {
                    CertPathValidatorUtilities.verifyX509Certificate(x509Certificate2, cAPublicKey2, this.pkixParams.getSigProvider());
                } catch (SignatureException unused) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustButInvalidCert"));
                } catch (Exception unused2) {
                }
            } catch (CertPathReviewerException e2) {
                e = e2;
                addError(e.getErrorMessage());
                trustAnchor2 = trustAnchor;
                if (trustAnchor2 == null) {
                }
                if (trustAnchor2 == null) {
                }
                X509Certificate x509Certificate3 = trustedCert;
                PublicKey nextWorkingKey = cAPublicKey;
                size = this.certs.size() - 1;
                while (size >= 0) {
                }
                this.trustAnchor = trustAnchor2;
                this.subjectPublicKey = nextWorkingKey;
            } catch (Throwable th2) {
                th = th2;
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknown", new Object[]{new UntrustedInput(th.getMessage()), new UntrustedInput(th)}));
                trustAnchor2 = trustAnchor;
                if (trustAnchor2 == null) {
                }
                if (trustAnchor2 == null) {
                }
                X509Certificate x509Certificate32 = trustedCert;
                PublicKey nextWorkingKey2 = cAPublicKey;
                size = this.certs.size() - 1;
                while (size >= 0) {
                }
                this.trustAnchor = trustAnchor2;
                this.subjectPublicKey = nextWorkingKey2;
            }
            trustAnchor2 = trustAnchor;
            if (trustAnchor2 == null) {
                X509Certificate trustedCert2 = trustAnchor2.getTrustedCert();
                try {
                    if (trustedCert2 != null) {
                        subjectX500Principal = getSubjectPrincipal(trustedCert2);
                    } else {
                        subjectX500Principal = new X500Principal(trustAnchor2.getCAName());
                    }
                } catch (IllegalArgumentException unused3) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustDNInvalid", new Object[]{new UntrustedInput(trustAnchor2.getCAName())}));
                    subjectX500Principal = null;
                }
                if (trustedCert2 != null && (keyUsage = trustedCert2.getKeyUsage()) != null && !keyUsage[5]) {
                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustKeyUsage"));
                }
            } else {
                subjectX500Principal = null;
            }
            if (trustAnchor2 == null) {
                trustedCert = trustAnchor2.getTrustedCert();
                if (trustedCert != null) {
                    cAPublicKey = trustedCert.getPublicKey();
                } else {
                    cAPublicKey = trustAnchor2.getCAPublicKey();
                }
                try {
                    AlgorithmIdentifier algorithmIdentifier = getAlgorithmIdentifier(cAPublicKey);
                    algorithmIdentifier.getAlgorithm();
                    algorithmIdentifier.getParameters();
                } catch (CertPathValidatorException unused4) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustPubKeyError"));
                }
            } else {
                trustedCert = null;
                cAPublicKey = null;
            }
            X509Certificate x509Certificate322 = trustedCert;
            PublicKey nextWorkingKey22 = cAPublicKey;
            size = this.certs.size() - 1;
            while (size >= 0) {
                int i2 = this.n - size;
                X509Certificate x509Certificate4 = (X509Certificate) this.certs.get(size);
                if (nextWorkingKey22 != null) {
                    try {
                        CertPathValidatorUtilities.verifyX509Certificate(x509Certificate4, nextWorkingKey22, this.pkixParams.getSigProvider());
                        c = 0;
                    } catch (GeneralSecurityException e3) {
                        c = 0;
                        String message = e3.getMessage();
                        String name = e3.getClass().getName();
                        Object[] objArr = new Object[3];
                        objArr[0] = message;
                        objArr[1] = e3;
                        objArr[c2] = name;
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.signatureNotVerified", objArr), size);
                    }
                } else {
                    c = 0;
                    if (isSelfIssued(x509Certificate4)) {
                        try {
                            CertPathValidatorUtilities.verifyX509Certificate(x509Certificate4, x509Certificate4.getPublicKey(), this.pkixParams.getSigProvider());
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.rootKeyIsValidButNotATrustAnchor"), size);
                        } catch (GeneralSecurityException e4) {
                            String message2 = e4.getMessage();
                            String name2 = e4.getClass().getName();
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = message2;
                            objArr2[1] = e4;
                            objArr2[c2] = name2;
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.signatureNotVerified", objArr2), size);
                        }
                    } else {
                        ErrorBundle errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.NoIssuerPublicKey");
                        byte[] extensionValue3 = x509Certificate4.getExtensionValue(Extension.authorityKeyIdentifier.getId());
                        if (extensionValue3 != null && (authorityCertIssuer = (authorityKeyIdentifier = AuthorityKeyIdentifier.getInstance(DEROctetString.getInstance(extensionValue3).getOctets())).getAuthorityCertIssuer()) != null) {
                            GeneralName generalName = authorityCertIssuer.getNames()[0];
                            BigInteger authorityCertSerialNumber = authorityKeyIdentifier.getAuthorityCertSerialNumber();
                            if (authorityCertSerialNumber != null) {
                                errorBundle.setExtraArguments(new Object[]{new LocaleString(RESOURCE_NAME, "missingIssuer"), " \"", generalName, "\" ", new LocaleString(RESOURCE_NAME, "missingSerial"), " ", authorityCertSerialNumber});
                            }
                            addError(errorBundle, size);
                        } else {
                            addError(errorBundle, size);
                        }
                        x509Certificate4.checkValidity(this.validDate);
                        if (this.pkixParams.isRevocationEnabled()) {
                            x500Principal = subjectX500Principal;
                            i = i2;
                            x509Certificate = x509Certificate4;
                        } else {
                            try {
                                extensionValue2 = getExtensionValue(x509Certificate4, CRL_DIST_POINTS);
                            } catch (AnnotatedException unused5) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlDistPtExtError"), size);
                            }
                            CRLDistPoint cRLDistPoint = extensionValue2 != null ? CRLDistPoint.getInstance(extensionValue2) : null;
                            try {
                                extensionValue = getExtensionValue(x509Certificate4, AUTH_INFO_ACCESS);
                            } catch (AnnotatedException unused6) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlAuthInfoAccError"), size);
                            }
                            AuthorityInformationAccess authorityInformationAccess = extensionValue != null ? AuthorityInformationAccess.getInstance(extensionValue) : null;
                            Vector cRLDistUrls = getCRLDistUrls(cRLDistPoint);
                            Vector oCSPUrls = getOCSPUrls(authorityInformationAccess);
                            Iterator it = cRLDistUrls.iterator();
                            while (it.hasNext()) {
                                Object[] objArr3 = new Object[1];
                                objArr3[c] = new UntrustedUrlInput(it.next());
                                addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlDistPoint", objArr3), size);
                            }
                            Iterator it2 = oCSPUrls.iterator();
                            while (it2.hasNext()) {
                                Object[] objArr4 = new Object[1];
                                objArr4[c] = new UntrustedUrlInput(it2.next());
                                addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ocspLocation", objArr4), size);
                            }
                            try {
                                i = i2;
                                x509Certificate = x509Certificate4;
                                try {
                                    x500Principal = subjectX500Principal;
                                    try {
                                        checkRevocation(this.pkixParams, x509Certificate, this.validDate, x509Certificate322, nextWorkingKey22, cRLDistUrls, oCSPUrls, size);
                                    } catch (CertPathReviewerException e5) {
                                        e = e5;
                                        addError(e.getErrorMessage(), size);
                                        if (x500Principal != null) {
                                        }
                                        if (i != this.n) {
                                        }
                                        subjectX500Principal = x509Certificate.getSubjectX500Principal();
                                        nextWorkingKey22 = getNextWorkingKey(this.certs, size);
                                        AlgorithmIdentifier algorithmIdentifier2 = getAlgorithmIdentifier(nextWorkingKey22);
                                        algorithmIdentifier2.getAlgorithm();
                                        algorithmIdentifier2.getParameters();
                                        size--;
                                        x509Certificate322 = x509Certificate;
                                        c2 = 2;
                                    }
                                } catch (CertPathReviewerException e6) {
                                    e = e6;
                                    x500Principal = subjectX500Principal;
                                }
                            } catch (CertPathReviewerException e7) {
                                e = e7;
                                x500Principal = subjectX500Principal;
                                i = i2;
                                x509Certificate = x509Certificate4;
                            }
                        }
                        if (x500Principal != null && !x509Certificate.getIssuerX500Principal().equals(x500Principal)) {
                            String name3 = x500Principal.getName();
                            String name4 = x509Certificate.getIssuerX500Principal().getName();
                            Object[] objArr5 = new Object[2];
                            objArr5[c] = name3;
                            objArr5[1] = name4;
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certWrongIssuer", objArr5), size);
                        }
                        if (i != this.n) {
                            if (x509Certificate != null && x509Certificate.getVersion() == 1) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCACert"), size);
                            }
                            try {
                                BasicConstraints basicConstraints = BasicConstraints.getInstance(getExtensionValue(x509Certificate, BASIC_CONSTRAINTS));
                                if (basicConstraints != null) {
                                    if (!basicConstraints.isCA()) {
                                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCACert"), size);
                                    }
                                } else {
                                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noBasicConstraints"), size);
                                }
                            } catch (AnnotatedException unused7) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.errorProcesingBC"), size);
                            }
                            boolean[] keyUsage2 = x509Certificate.getKeyUsage();
                            if (keyUsage2 != null && !keyUsage2[5]) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCertSign"), size);
                            }
                        }
                        subjectX500Principal = x509Certificate.getSubjectX500Principal();
                        nextWorkingKey22 = getNextWorkingKey(this.certs, size);
                        AlgorithmIdentifier algorithmIdentifier22 = getAlgorithmIdentifier(nextWorkingKey22);
                        algorithmIdentifier22.getAlgorithm();
                        algorithmIdentifier22.getParameters();
                        size--;
                        x509Certificate322 = x509Certificate;
                        c2 = 2;
                    }
                }
                x509Certificate4.checkValidity(this.validDate);
                if (this.pkixParams.isRevocationEnabled()) {
                }
                if (x500Principal != null) {
                }
                if (i != this.n) {
                }
                subjectX500Principal = x509Certificate.getSubjectX500Principal();
                nextWorkingKey22 = getNextWorkingKey(this.certs, size);
                AlgorithmIdentifier algorithmIdentifier222 = getAlgorithmIdentifier(nextWorkingKey22);
                algorithmIdentifier222.getAlgorithm();
                algorithmIdentifier222.getParameters();
                size--;
                x509Certificate322 = x509Certificate;
                c2 = 2;
            }
            this.trustAnchor = trustAnchor2;
            this.subjectPublicKey = nextWorkingKey22;
        }
        trustAnchor = null;
        trustAnchor2 = trustAnchor;
        if (trustAnchor2 == null) {
        }
        if (trustAnchor2 == null) {
        }
        X509Certificate x509Certificate3222 = trustedCert;
        PublicKey nextWorkingKey222 = cAPublicKey;
        size = this.certs.size() - 1;
        while (size >= 0) {
        }
        this.trustAnchor = trustAnchor2;
        this.subjectPublicKey = nextWorkingKey222;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0144, code lost:
    
        r22 = getQualifierSet(r10.getPolicyQualifiers());
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014e, code lost:
    
        r9 = r5[r14 - 1];
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0155, code lost:
    
        if (r10 >= r9.size()) goto L379;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0157, code lost:
    
        r21 = (org.spongycastle.jce.provider.PKIXPolicyNode) r9.get(r10);
        r11 = r21.getExpectedPolicies().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x016b, code lost:
    
        if (r11.hasNext() == false) goto L380;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x016d, code lost:
    
        r30 = r9;
        r9 = r11.next();
        r31 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0177, code lost:
    
        if ((r9 instanceof java.lang.String) == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0179, code lost:
    
        r9 = (java.lang.String) r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017e, code lost:
    
        if ((r9 instanceof org.spongycastle.asn1.ASN1ObjectIdentifier) == false) goto L382;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0180, code lost:
    
        r9 = ((org.spongycastle.asn1.ASN1ObjectIdentifier) r9).getId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0186, code lost:
    
        r10 = r21.getChildren();
        r17 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0190, code lost:
    
        if (r10.hasNext() == false) goto L384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0192, code lost:
    
        r19 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a2, code lost:
    
        if (r9.equals(((org.spongycastle.jce.provider.PKIXPolicyNode) r10.next()).getValidPolicy()) == false) goto L386;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a4, code lost:
    
        r17 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a6, code lost:
    
        r10 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01a9, code lost:
    
        if (r17 != false) goto L383;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ab, code lost:
    
        r10 = new java.util.HashSet();
        r10.add(r9);
        r17 = new org.spongycastle.jce.provider.PKIXPolicyNode(new java.util.ArrayList(), r14, r10, r21, r22, r9, false);
        r9 = r21;
        r9.addChild(r17);
        r21 = r9;
        r5[r14].add(r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01d3, code lost:
    
        r9 = r30;
        r10 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01d8, code lost:
    
        r10 = r10 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkPolicy() throws CertPathReviewerException {
        PKIXPolicyNode pKIXPolicyNodeRemovePolicyNode;
        PKIXPolicyNode pKIXPolicyNode;
        int i;
        int i2;
        int i3;
        ASN1Primitive aSN1Primitive;
        Set<String> set;
        HashSet hashSet;
        int iIntValue;
        int iIntValue2;
        HashSet hashSet2;
        int i4;
        Set<String> initialPolicies = this.pkixParams.getInitialPolicies();
        int i5 = this.n + 1;
        ArrayList[] arrayListArr = new ArrayList[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            arrayListArr[i6] = new ArrayList();
        }
        HashSet hashSet3 = new HashSet();
        hashSet3.add("2.5.29.32.0");
        PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), 0, hashSet3, null, new HashSet(), "2.5.29.32.0", false);
        arrayListArr[0].add(pKIXPolicyNode2);
        int i7 = this.pkixParams.isExplicitPolicyRequired() ? 0 : this.n + 1;
        int i8 = this.pkixParams.isAnyPolicyInhibited() ? 0 : this.n + 1;
        int i9 = this.pkixParams.isPolicyMappingInhibited() ? 0 : this.n + 1;
        try {
            int size = this.certs.size() - 1;
            X509Certificate x509Certificate = null;
            HashSet hashSet4 = null;
            while (size >= 0) {
                int i10 = this.n - size;
                X509Certificate x509Certificate2 = (X509Certificate) this.certs.get(size);
                PKIXPolicyNode pKIXPolicyNode3 = pKIXPolicyNode2;
                try {
                    ASN1Sequence aSN1Sequence = (ASN1Sequence) getExtensionValue(x509Certificate2, CERTIFICATE_POLICIES);
                    if (aSN1Sequence == null || pKIXPolicyNode3 == null) {
                        i = i7;
                        i2 = i8;
                        i3 = i9;
                    } else {
                        Enumeration objects = aSN1Sequence.getObjects();
                        i = i7;
                        HashSet hashSet5 = new HashSet();
                        while (objects.hasMoreElements()) {
                            PolicyInformation policyInformation = PolicyInformation.getInstance(objects.nextElement());
                            int i11 = i8;
                            ASN1ObjectIdentifier policyIdentifier = policyInformation.getPolicyIdentifier();
                            int i12 = i9;
                            hashSet5.add(policyIdentifier.getId());
                            if (!"2.5.29.32.0".equals(policyIdentifier.getId())) {
                                try {
                                    Set qualifierSet = getQualifierSet(policyInformation.getPolicyQualifiers());
                                    if (!processCertD1i(i10, arrayListArr, policyIdentifier, qualifierSet)) {
                                        processCertD1ii(i10, arrayListArr, policyIdentifier, qualifierSet);
                                    }
                                } catch (CertPathValidatorException e) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyQualifierError"), e, this.certPath, size);
                                }
                            }
                            i8 = i11;
                            i9 = i12;
                        }
                        i2 = i8;
                        i3 = i9;
                        if (hashSet4 == null || hashSet4.contains("2.5.29.32.0")) {
                            hashSet2 = hashSet5;
                        } else {
                            HashSet hashSet6 = new HashSet();
                            for (Object obj : hashSet4) {
                                if (hashSet5.contains(obj)) {
                                    hashSet6.add(obj);
                                }
                            }
                            hashSet2 = hashSet6;
                        }
                        if (i2 > 0 || (i10 < this.n && isSelfIssued(x509Certificate2))) {
                            Enumeration objects2 = aSN1Sequence.getObjects();
                            while (true) {
                                if (!objects2.hasMoreElements()) {
                                    break;
                                }
                                PolicyInformation policyInformation2 = PolicyInformation.getInstance(objects2.nextElement());
                                if ("2.5.29.32.0".equals(policyInformation2.getPolicyIdentifier().getId())) {
                                    try {
                                        break;
                                    } catch (CertPathValidatorException e2) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyQualifierError"), e2, this.certPath, size);
                                    }
                                }
                            }
                        }
                        int i13 = i10 - 1;
                        while (i13 >= 0) {
                            ArrayList arrayList = arrayListArr[i13];
                            int i14 = i13;
                            HashSet hashSet7 = hashSet2;
                            PKIXPolicyNode pKIXPolicyNodeRemovePolicyNode2 = pKIXPolicyNode3;
                            while (i4 < arrayList.size()) {
                                PKIXPolicyNode pKIXPolicyNode4 = (PKIXPolicyNode) arrayList.get(i4);
                                i4 = (pKIXPolicyNode4.hasChildren() || (pKIXPolicyNodeRemovePolicyNode2 = removePolicyNode(pKIXPolicyNodeRemovePolicyNode2, arrayListArr, pKIXPolicyNode4)) != null) ? i4 + 1 : 0;
                            }
                            pKIXPolicyNode3 = pKIXPolicyNodeRemovePolicyNode2;
                            i13 = i14 - 1;
                            hashSet2 = hashSet7;
                        }
                        HashSet hashSet8 = hashSet2;
                        Set<String> criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs != null) {
                            boolean zContains = criticalExtensionOIDs.contains(CERTIFICATE_POLICIES);
                            ArrayList arrayList2 = arrayListArr[i10];
                            for (int i15 = 0; i15 < arrayList2.size(); i15++) {
                                ((PKIXPolicyNode) arrayList2.get(i15)).setCritical(zContains);
                            }
                        }
                        hashSet4 = hashSet8;
                    }
                    if (aSN1Sequence == null) {
                        pKIXPolicyNode3 = null;
                    }
                    if (i <= 0 && pKIXPolicyNode3 == null) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noValidPolicyTree"));
                    }
                    if (i10 != this.n) {
                        try {
                            ASN1Primitive extensionValue = getExtensionValue(x509Certificate2, POLICY_MAPPINGS);
                            if (extensionValue != null) {
                                ASN1Sequence aSN1Sequence2 = (ASN1Sequence) extensionValue;
                                aSN1Primitive = extensionValue;
                                int i16 = 0;
                                while (i16 < aSN1Sequence2.size()) {
                                    ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence2.getObjectAt(i16);
                                    ASN1Sequence aSN1Sequence4 = aSN1Sequence2;
                                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence3.getObjectAt(0);
                                    ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) aSN1Sequence3.getObjectAt(1);
                                    if (!"2.5.29.32.0".equals(aSN1ObjectIdentifier.getId())) {
                                        if ("2.5.29.32.0".equals(aSN1ObjectIdentifier2.getId())) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.invalidPolicyMapping"), this.certPath, size);
                                        }
                                        i16++;
                                        aSN1Sequence2 = aSN1Sequence4;
                                    } else {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.invalidPolicyMapping"), this.certPath, size);
                                    }
                                }
                            } else {
                                aSN1Primitive = extensionValue;
                            }
                            if (aSN1Primitive != null) {
                                ASN1Sequence aSN1Sequence5 = (ASN1Sequence) aSN1Primitive;
                                HashMap map = new HashMap();
                                HashSet<String> hashSet9 = new HashSet();
                                set = initialPolicies;
                                hashSet = hashSet4;
                                int i17 = 0;
                                while (i17 < aSN1Sequence5.size()) {
                                    ASN1Sequence aSN1Sequence6 = (ASN1Sequence) aSN1Sequence5.getObjectAt(i17);
                                    ASN1Sequence aSN1Sequence7 = aSN1Sequence5;
                                    String id = ((ASN1ObjectIdentifier) aSN1Sequence6.getObjectAt(0)).getId();
                                    int i18 = i17;
                                    String id2 = ((ASN1ObjectIdentifier) aSN1Sequence6.getObjectAt(1)).getId();
                                    if (!map.containsKey(id)) {
                                        HashSet hashSet10 = new HashSet();
                                        hashSet10.add(id2);
                                        map.put(id, hashSet10);
                                        hashSet9.add(id);
                                    } else {
                                        ((Set) map.get(id)).add(id2);
                                    }
                                    i17 = i18 + 1;
                                    aSN1Sequence5 = aSN1Sequence7;
                                }
                                PKIXPolicyNode pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNode3;
                                for (String str : hashSet9) {
                                    if (i3 > 0) {
                                        try {
                                            prepareNextCertB1(i10, arrayListArr, str, map, x509Certificate2);
                                        } catch (CertPathValidatorException e3) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyQualifierError"), e3, this.certPath, size);
                                        } catch (AnnotatedException e4) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyExtError"), e4, this.certPath, size);
                                        }
                                    } else if (i3 <= 0) {
                                        pKIXPolicyNodePrepareNextCertB2 = prepareNextCertB2(i10, arrayListArr, str, pKIXPolicyNodePrepareNextCertB2);
                                    }
                                }
                                pKIXPolicyNode3 = pKIXPolicyNodePrepareNextCertB2;
                            } else {
                                set = initialPolicies;
                                hashSet = hashSet4;
                            }
                            if (isSelfIssued(x509Certificate2)) {
                                i7 = i;
                                i8 = i2;
                                i9 = i3;
                            } else {
                                i7 = i != 0 ? i - 1 : i;
                                i9 = i3 != 0 ? i3 - 1 : i3;
                                i8 = i2 != 0 ? i2 - 1 : i2;
                            }
                            try {
                                ASN1Sequence aSN1Sequence8 = (ASN1Sequence) getExtensionValue(x509Certificate2, POLICY_CONSTRAINTS);
                                if (aSN1Sequence8 != null) {
                                    Enumeration objects3 = aSN1Sequence8.getObjects();
                                    while (objects3.hasMoreElements()) {
                                        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects3.nextElement();
                                        int tagNo = aSN1TaggedObject.getTagNo();
                                        if (tagNo == 0) {
                                            int iIntValue3 = ASN1Integer.getInstance(aSN1TaggedObject, false).getValue().intValue();
                                            if (iIntValue3 < i7) {
                                                i7 = iIntValue3;
                                            }
                                        } else if (tagNo == 1 && (iIntValue2 = ASN1Integer.getInstance(aSN1TaggedObject, false).getValue().intValue()) < i9) {
                                            i9 = iIntValue2;
                                        }
                                    }
                                }
                                try {
                                    ASN1Integer aSN1Integer = (ASN1Integer) getExtensionValue(x509Certificate2, INHIBIT_ANY_POLICY);
                                    if (aSN1Integer != null && (iIntValue = aSN1Integer.getValue().intValue()) < i8) {
                                        i8 = iIntValue;
                                    }
                                } catch (AnnotatedException unused) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyInhibitExtError"), this.certPath, size);
                                }
                            } catch (AnnotatedException unused2) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyConstExtError"), this.certPath, size);
                            }
                        } catch (AnnotatedException e5) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyMapExtError"), e5, this.certPath, size);
                        }
                    } else {
                        set = initialPolicies;
                        hashSet = hashSet4;
                        i7 = i;
                        i8 = i2;
                        i9 = i3;
                    }
                    pKIXPolicyNode2 = pKIXPolicyNode3;
                    size--;
                    x509Certificate = x509Certificate2;
                    hashSet4 = hashSet;
                    initialPolicies = set;
                } catch (AnnotatedException e6) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyExtError"), e6, this.certPath, size);
                }
            }
            Set<String> set2 = initialPolicies;
            PKIXPolicyNode pKIXPolicyNode5 = pKIXPolicyNode2;
            int i19 = i7;
            int i20 = (isSelfIssued(x509Certificate) || i19 <= 0) ? i19 : i19 - 1;
            try {
                ASN1Sequence aSN1Sequence9 = (ASN1Sequence) getExtensionValue(x509Certificate, POLICY_CONSTRAINTS);
                if (aSN1Sequence9 != null) {
                    Enumeration objects4 = aSN1Sequence9.getObjects();
                    int i21 = i20;
                    while (objects4.hasMoreElements()) {
                        ASN1TaggedObject aSN1TaggedObject2 = (ASN1TaggedObject) objects4.nextElement();
                        if (aSN1TaggedObject2.getTagNo() == 0 && ASN1Integer.getInstance(aSN1TaggedObject2, false).getValue().intValue() == 0) {
                            i21 = 0;
                        }
                    }
                    i20 = i21;
                }
                if (pKIXPolicyNode5 == null) {
                    if (this.pkixParams.isExplicitPolicyRequired()) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.explicitPolicy"), this.certPath, size);
                    }
                    pKIXPolicyNode = null;
                } else {
                    if (isAnyPolicy(set2)) {
                        if (this.pkixParams.isExplicitPolicyRequired()) {
                            if (hashSet4.isEmpty()) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.explicitPolicy"), this.certPath, size);
                            }
                            HashSet hashSet11 = new HashSet();
                            for (int i22 = 0; i22 < i5; i22++) {
                                ArrayList arrayList3 = arrayListArr[i22];
                                for (int i23 = 0; i23 < arrayList3.size(); i23++) {
                                    PKIXPolicyNode pKIXPolicyNode6 = (PKIXPolicyNode) arrayList3.get(i23);
                                    if ("2.5.29.32.0".equals(pKIXPolicyNode6.getValidPolicy())) {
                                        Iterator children = pKIXPolicyNode6.getChildren();
                                        while (children.hasNext()) {
                                            hashSet11.add(children.next());
                                        }
                                    }
                                }
                            }
                            Iterator it = hashSet11.iterator();
                            while (it.hasNext()) {
                                hashSet4.contains(((PKIXPolicyNode) it.next()).getValidPolicy());
                            }
                            if (pKIXPolicyNode5 != null) {
                                pKIXPolicyNodeRemovePolicyNode = pKIXPolicyNode5;
                                for (int i24 = this.n - 1; i24 >= 0; i24--) {
                                    ArrayList arrayList4 = arrayListArr[i24];
                                    for (int i25 = 0; i25 < arrayList4.size(); i25++) {
                                        PKIXPolicyNode pKIXPolicyNode7 = (PKIXPolicyNode) arrayList4.get(i25);
                                        if (!pKIXPolicyNode7.hasChildren()) {
                                            pKIXPolicyNodeRemovePolicyNode = removePolicyNode(pKIXPolicyNodeRemovePolicyNode, arrayListArr, pKIXPolicyNode7);
                                        }
                                    }
                                }
                            }
                        }
                        pKIXPolicyNode = pKIXPolicyNode5;
                    } else {
                        HashSet<PKIXPolicyNode> hashSet12 = new HashSet();
                        for (int i26 = 0; i26 < i5; i26++) {
                            ArrayList arrayList5 = arrayListArr[i26];
                            for (int i27 = 0; i27 < arrayList5.size(); i27++) {
                                PKIXPolicyNode pKIXPolicyNode8 = (PKIXPolicyNode) arrayList5.get(i27);
                                if ("2.5.29.32.0".equals(pKIXPolicyNode8.getValidPolicy())) {
                                    Iterator children2 = pKIXPolicyNode8.getChildren();
                                    while (children2.hasNext()) {
                                        PKIXPolicyNode pKIXPolicyNode9 = (PKIXPolicyNode) children2.next();
                                        if (!"2.5.29.32.0".equals(pKIXPolicyNode9.getValidPolicy())) {
                                            hashSet12.add(pKIXPolicyNode9);
                                        }
                                    }
                                }
                            }
                        }
                        pKIXPolicyNodeRemovePolicyNode = pKIXPolicyNode5;
                        for (PKIXPolicyNode pKIXPolicyNode10 : hashSet12) {
                            Set<String> set3 = set2;
                            if (!set3.contains(pKIXPolicyNode10.getValidPolicy())) {
                                pKIXPolicyNodeRemovePolicyNode = removePolicyNode(pKIXPolicyNodeRemovePolicyNode, arrayListArr, pKIXPolicyNode10);
                            }
                            set2 = set3;
                        }
                        if (pKIXPolicyNodeRemovePolicyNode != null) {
                            for (int i28 = this.n - 1; i28 >= 0; i28--) {
                                ArrayList arrayList6 = arrayListArr[i28];
                                for (int i29 = 0; i29 < arrayList6.size(); i29++) {
                                    PKIXPolicyNode pKIXPolicyNode11 = (PKIXPolicyNode) arrayList6.get(i29);
                                    if (!pKIXPolicyNode11.hasChildren()) {
                                        pKIXPolicyNodeRemovePolicyNode = removePolicyNode(pKIXPolicyNodeRemovePolicyNode, arrayListArr, pKIXPolicyNode11);
                                    }
                                }
                            }
                        }
                    }
                    pKIXPolicyNode = pKIXPolicyNodeRemovePolicyNode;
                }
                if (i20 <= 0 && pKIXPolicyNode == null) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.invalidPolicy"));
                }
            } catch (AnnotatedException unused3) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyConstExtError"), this.certPath, size);
            }
        } catch (CertPathReviewerException e7) {
            addError(e7.getErrorMessage(), e7.getIndex());
        }
    }

    private void checkCriticalExtensions() throws CertPathValidatorException, CertPathReviewerException {
        List<PKIXCertPathChecker> certPathCheckers = this.pkixParams.getCertPathCheckers();
        Iterator<PKIXCertPathChecker> it = certPathCheckers.iterator();
        while (it.hasNext()) {
            try {
                try {
                    it.next().init(false);
                } catch (CertPathValidatorException e) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathCheckerError", new Object[]{e.getMessage(), e, e.getClass().getName()}), e);
                }
            } catch (CertPathReviewerException e2) {
                addError(e2.getErrorMessage(), e2.getIndex());
                return;
            }
        }
        for (int size = this.certs.size() - 1; size >= 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty()) {
                criticalExtensionOIDs.remove(KEY_USAGE);
                criticalExtensionOIDs.remove(CERTIFICATE_POLICIES);
                criticalExtensionOIDs.remove(POLICY_MAPPINGS);
                criticalExtensionOIDs.remove(INHIBIT_ANY_POLICY);
                criticalExtensionOIDs.remove(ISSUING_DISTRIBUTION_POINT);
                criticalExtensionOIDs.remove(DELTA_CRL_INDICATOR);
                criticalExtensionOIDs.remove(POLICY_CONSTRAINTS);
                criticalExtensionOIDs.remove(BASIC_CONSTRAINTS);
                criticalExtensionOIDs.remove(SUBJECT_ALTERNATIVE_NAME);
                criticalExtensionOIDs.remove(NAME_CONSTRAINTS);
                String str = QC_STATEMENT;
                if (criticalExtensionOIDs.contains(str) && processQcStatements(x509Certificate, size)) {
                    criticalExtensionOIDs.remove(str);
                }
                Iterator<PKIXCertPathChecker> it2 = certPathCheckers.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().check(x509Certificate, criticalExtensionOIDs);
                    } catch (CertPathValidatorException e3) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.criticalExtensionError", new Object[]{e3.getMessage(), e3, e3.getClass().getName()}), e3.getCause(), this.certPath, size);
                    }
                }
                if (!criticalExtensionOIDs.isEmpty()) {
                    Iterator<String> it3 = criticalExtensionOIDs.iterator();
                    while (it3.hasNext()) {
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknownCriticalExt", new Object[]{new ASN1ObjectIdentifier(it3.next())}), size);
                    }
                }
            }
        }
    }

    private boolean processQcStatements(X509Certificate x509Certificate, int i) {
        boolean z;
        ASN1Sequence aSN1Sequence;
        ErrorBundle errorBundle;
        try {
            ASN1Sequence aSN1Sequence2 = (ASN1Sequence) getExtensionValue(x509Certificate, QC_STATEMENT);
            int i2 = 0;
            boolean z2 = false;
            while (i2 < aSN1Sequence2.size()) {
                QCStatement qCStatement = QCStatement.getInstance(aSN1Sequence2.getObjectAt(i2));
                if (QCStatement.id_etsi_qcs_QcCompliance.equals(qCStatement.getStatementId())) {
                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcEuCompliance"), i);
                } else {
                    if (!QCStatement.id_qcs_pkixQCSyntax_v1.equals(qCStatement.getStatementId())) {
                        if (QCStatement.id_etsi_qcs_QcSSCD.equals(qCStatement.getStatementId())) {
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcSSCD"), i);
                        } else if (QCStatement.id_etsi_qcs_LimiteValue.equals(qCStatement.getStatementId())) {
                            MonetaryValue monetaryValue = MonetaryValue.getInstance(qCStatement.getStatementInfo());
                            monetaryValue.getCurrency();
                            aSN1Sequence = aSN1Sequence2;
                            z = false;
                            try {
                                double dDoubleValue = monetaryValue.getAmount().doubleValue() * Math.pow(10.0d, monetaryValue.getExponent().doubleValue());
                                if (monetaryValue.getCurrency().isAlphabetic()) {
                                    errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueAlpha", new Object[]{monetaryValue.getCurrency().getAlphabetic(), new TrustedInput(new Double(dDoubleValue)), monetaryValue});
                                } else {
                                    errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueNum", new Object[]{Integers.valueOf(monetaryValue.getCurrency().getNumeric()), new TrustedInput(new Double(dDoubleValue)), monetaryValue});
                                }
                                addNotification(errorBundle, i);
                            } catch (AnnotatedException unused) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcStatementExtError"), i);
                                return z;
                            }
                        } else {
                            aSN1Sequence = aSN1Sequence2;
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcUnknownStatement", new Object[]{qCStatement.getStatementId(), new UntrustedInput(qCStatement)}), i);
                            z2 = true;
                        }
                    }
                    i2++;
                    aSN1Sequence2 = aSN1Sequence;
                }
                aSN1Sequence = aSN1Sequence2;
                i2++;
                aSN1Sequence2 = aSN1Sequence;
            }
            return !z2;
        } catch (AnnotatedException unused2) {
            z = false;
        }
    }

    private String IPtoString(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (Exception unused) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i != bArr.length; i++) {
                stringBuffer.append(Integer.toHexString(bArr[i] & 255));
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
    }

    protected void checkRevocation(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, Vector vector2, int i) throws Exception {
        checkCRLs(pKIXParameters, x509Certificate, date, x509Certificate2, publicKey, vector, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x048e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x025f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void checkCRLs(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, int i) throws Exception {
        char c;
        char c2;
        char c3;
        Iterator it;
        X509CRL x509crl;
        boolean z;
        boolean[] keyUsage;
        X509CRL x509crl2;
        Iterator it2;
        boolean z2;
        String str;
        X509CRL crl;
        TrustedInput trustedInput;
        TrustedInput trustedInput2;
        UntrustedUrlInput untrustedUrlInput;
        ArrayList arrayList;
        X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
        try {
            x509CRLStoreSelector.addIssuerName(getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            x509CRLStoreSelector.setCertificateChecking(x509Certificate);
            try {
                Set setFindCRLs = CRL_UTIL.findCRLs(x509CRLStoreSelector, pKIXParameters);
                it = setFindCRLs.iterator();
                if (setFindCRLs.isEmpty()) {
                    c = 0;
                    try {
                        Iterator it3 = CRL_UTIL.findCRLs(new X509CRLStoreSelector(), pKIXParameters).iterator();
                        arrayList = new ArrayList();
                        while (it3.hasNext()) {
                            try {
                                c3 = 1;
                            } catch (AnnotatedException e) {
                                e = e;
                                c3 = 1;
                                c2 = 2;
                                String message = e.getCause().getMessage();
                                Throwable cause = e.getCause();
                                String name = e.getCause().getClass().getName();
                                Object[] objArr = new Object[3];
                                objArr[c] = message;
                                objArr[c3] = cause;
                                objArr[c2] = name;
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlExtractionError", objArr), i);
                                it = new ArrayList().iterator();
                                X509CRL x509crl3 = null;
                                while (it.hasNext()) {
                                }
                                x509crl = x509crl3;
                                z = false;
                                if (!z) {
                                }
                                if (x509crl != null) {
                                }
                                if (!z) {
                                }
                            }
                            try {
                                arrayList.add(((X509CRL) it3.next()).getIssuerX500Principal());
                            } catch (AnnotatedException e2) {
                                e = e2;
                                c2 = 2;
                                String message2 = e.getCause().getMessage();
                                Throwable cause2 = e.getCause();
                                String name2 = e.getCause().getClass().getName();
                                Object[] objArr2 = new Object[3];
                                objArr2[c] = message2;
                                objArr2[c3] = cause2;
                                objArr2[c2] = name2;
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlExtractionError", objArr2), i);
                                it = new ArrayList().iterator();
                                X509CRL x509crl32 = null;
                                while (it.hasNext()) {
                                }
                                x509crl = x509crl32;
                                z = false;
                                if (!z) {
                                }
                                if (x509crl != null) {
                                }
                                if (!z) {
                                }
                            }
                        }
                        c3 = 1;
                        c2 = 2;
                    } catch (AnnotatedException e3) {
                        e = e3;
                        c2 = 2;
                        c3 = 1;
                        String message22 = e.getCause().getMessage();
                        Throwable cause22 = e.getCause();
                        String name22 = e.getCause().getClass().getName();
                        Object[] objArr22 = new Object[3];
                        objArr22[c] = message22;
                        objArr22[c3] = cause22;
                        objArr22[c2] = name22;
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlExtractionError", objArr22), i);
                        it = new ArrayList().iterator();
                        X509CRL x509crl322 = null;
                        while (it.hasNext()) {
                        }
                        x509crl = x509crl322;
                        z = false;
                        if (!z) {
                        }
                        if (x509crl != null) {
                        }
                        if (!z) {
                        }
                    }
                    try {
                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCrlInCertstore", new Object[]{new UntrustedInput(x509CRLStoreSelector.getIssuerNames()), new UntrustedInput(arrayList), Integers.valueOf(arrayList.size())}), i);
                    } catch (AnnotatedException e4) {
                        e = e4;
                        String message222 = e.getCause().getMessage();
                        Throwable cause222 = e.getCause();
                        String name222 = e.getCause().getClass().getName();
                        Object[] objArr222 = new Object[3];
                        objArr222[c] = message222;
                        objArr222[c3] = cause222;
                        objArr222[c2] = name222;
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlExtractionError", objArr222), i);
                        it = new ArrayList().iterator();
                        X509CRL x509crl3222 = null;
                        while (it.hasNext()) {
                        }
                        x509crl = x509crl3222;
                        z = false;
                        if (!z) {
                        }
                        if (x509crl != null) {
                        }
                        if (!z) {
                        }
                    }
                } else {
                    c = 0;
                    c3 = 1;
                }
            } catch (AnnotatedException e5) {
                e = e5;
                c = 0;
            }
            X509CRL x509crl32222 = null;
            while (it.hasNext()) {
                x509crl32222 = (X509CRL) it.next();
                if (x509crl32222.getNextUpdate() == null || pKIXParameters.getDate().before(x509crl32222.getNextUpdate())) {
                    TrustedInput trustedInput3 = new TrustedInput(x509crl32222.getThisUpdate());
                    TrustedInput trustedInput4 = new TrustedInput(x509crl32222.getNextUpdate());
                    Object[] objArr3 = new Object[2];
                    objArr3[c] = trustedInput3;
                    objArr3[c3] = trustedInput4;
                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.localValidCRL", objArr3), i);
                    x509crl = x509crl32222;
                    z = true;
                    break;
                }
                TrustedInput trustedInput5 = new TrustedInput(x509crl32222.getThisUpdate());
                TrustedInput trustedInput6 = new TrustedInput(x509crl32222.getNextUpdate());
                Object[] objArr4 = new Object[2];
                objArr4[c] = trustedInput5;
                objArr4[c3] = trustedInput6;
                addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.localInvalidCRL", objArr4), i);
            }
            x509crl = x509crl32222;
            z = false;
            if (!z) {
                Iterator it4 = vector.iterator();
                boolean z3 = z;
                while (true) {
                    if (!it4.hasNext()) {
                        z = z3;
                        x509crl = x509crl;
                        break;
                    }
                    try {
                        str = (String) it4.next();
                        crl = getCRL(str);
                    } catch (CertPathReviewerException e6) {
                        e = e6;
                        x509crl2 = x509crl;
                    }
                    if (crl == null) {
                        x509crl2 = x509crl;
                    } else if (!x509Certificate.getIssuerX500Principal().equals(crl.getIssuerX500Principal())) {
                        x509crl2 = x509crl;
                        try {
                            UntrustedInput untrustedInput = new UntrustedInput(crl.getIssuerX500Principal().getName());
                            UntrustedInput untrustedInput2 = new UntrustedInput(x509Certificate.getIssuerX500Principal().getName());
                            UntrustedUrlInput untrustedUrlInput2 = new UntrustedUrlInput(str);
                            Object[] objArr5 = new Object[3];
                            objArr5[c] = untrustedInput;
                            objArr5[c3] = untrustedInput2;
                            objArr5[2] = untrustedUrlInput2;
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.onlineCRLWrongCA", objArr5), i);
                        } catch (CertPathReviewerException e7) {
                            e = e7;
                            it2 = it4;
                            z2 = z3;
                            addNotification(e.getErrorMessage(), i);
                            it4 = it2;
                            z3 = z2;
                            x509crl = x509crl2;
                        }
                    } else {
                        x509crl2 = x509crl;
                        if (crl.getNextUpdate() != null && !this.pkixParams.getDate().before(crl.getNextUpdate())) {
                            it2 = it4;
                            try {
                                TrustedInput trustedInput7 = new TrustedInput(crl.getThisUpdate());
                                TrustedInput trustedInput8 = new TrustedInput(crl.getNextUpdate());
                                UntrustedUrlInput untrustedUrlInput3 = new UntrustedUrlInput(str);
                                Object[] objArr6 = new Object[3];
                                objArr6[c] = trustedInput7;
                                objArr6[c3] = trustedInput8;
                                objArr6[2] = untrustedUrlInput3;
                                addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.onlineInvalidCRL", objArr6), i);
                                z2 = z3;
                            } catch (CertPathReviewerException e8) {
                                e = e8;
                                z2 = z3;
                                addNotification(e.getErrorMessage(), i);
                                it4 = it2;
                                z3 = z2;
                                x509crl = x509crl2;
                            }
                            it4 = it2;
                            z3 = z2;
                            x509crl = x509crl2;
                        }
                        it2 = it4;
                        try {
                            trustedInput = new TrustedInput(crl.getThisUpdate());
                            trustedInput2 = new TrustedInput(crl.getNextUpdate());
                            untrustedUrlInput = new UntrustedUrlInput(str);
                        } catch (CertPathReviewerException e9) {
                            e = e9;
                        }
                        try {
                            Object[] objArr7 = new Object[3];
                            objArr7[c] = trustedInput;
                            objArr7[c3] = trustedInput2;
                            objArr7[2] = untrustedUrlInput;
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.onlineValidCRL", objArr7), i);
                            x509crl = crl;
                            z = true;
                            break;
                        } catch (CertPathReviewerException e10) {
                            e = e10;
                            z2 = true;
                            addNotification(e.getErrorMessage(), i);
                            it4 = it2;
                            z3 = z2;
                            x509crl = x509crl2;
                        }
                    }
                    it2 = it4;
                    z2 = z3;
                    it4 = it2;
                    z3 = z2;
                    x509crl = x509crl2;
                }
            }
            if (x509crl != null) {
                if (x509Certificate2 != null && (keyUsage = x509Certificate2.getKeyUsage()) != null && (keyUsage.length < 7 || !keyUsage[6])) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCrlSigningPermited"));
                }
                if (publicKey != null) {
                    try {
                        x509crl.verify(publicKey, BouncyCastleProvider.PROVIDER_NAME);
                        X509CRLEntry revokedCertificate = x509crl.getRevokedCertificate(x509Certificate.getSerialNumber());
                        if (revokedCertificate != null) {
                            if (revokedCertificate.hasExtensions()) {
                                try {
                                    ASN1Enumerated aSN1Enumerated = ASN1Enumerated.getInstance(getExtensionValue(revokedCertificate, Extension.reasonCode.getId()));
                                    String str2 = aSN1Enumerated != null ? crlReasons[aSN1Enumerated.getValue().intValue()] : null;
                                    if (str2 == null) {
                                        str2 = crlReasons[7];
                                    }
                                    LocaleString localeString = new LocaleString(RESOURCE_NAME, str2);
                                    if (!date.before(revokedCertificate.getRevocationDate())) {
                                        Object[] objArr8 = new Object[2];
                                        objArr8[c] = new TrustedInput(revokedCertificate.getRevocationDate());
                                        objArr8[c3] = localeString;
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certRevoked", objArr8));
                                    }
                                    TrustedInput trustedInput9 = new TrustedInput(revokedCertificate.getRevocationDate());
                                    Object[] objArr9 = new Object[2];
                                    objArr9[c] = trustedInput9;
                                    objArr9[c3] = localeString;
                                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.revokedAfterValidation", objArr9), i);
                                } catch (AnnotatedException e11) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlReasonExtError"), e11);
                                }
                            }
                        } else {
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notRevoked"), i);
                        }
                        if (x509crl.getNextUpdate() != null && x509crl.getNextUpdate().before(this.pkixParams.getDate())) {
                            Object[] objArr10 = new Object[1];
                            objArr10[c] = new TrustedInput(x509crl.getNextUpdate());
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlUpdateAvailable", objArr10), i);
                        }
                        try {
                            ASN1Primitive extensionValue = getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT);
                            try {
                                ASN1Primitive extensionValue2 = getExtensionValue(x509crl, DELTA_CRL_INDICATOR);
                                if (extensionValue2 != null) {
                                    X509CRLStoreSelector x509CRLStoreSelector2 = new X509CRLStoreSelector();
                                    try {
                                        x509CRLStoreSelector2.addIssuerName(getIssuerPrincipal(x509crl).getEncoded());
                                        x509CRLStoreSelector2.setMinCRLNumber(((ASN1Integer) extensionValue2).getPositiveValue());
                                        try {
                                            x509CRLStoreSelector2.setMaxCRLNumber(((ASN1Integer) getExtensionValue(x509crl, CRL_NUMBER)).getPositiveValue().subtract(BigInteger.valueOf(1L)));
                                            try {
                                                Iterator it5 = CRL_UTIL.findCRLs(x509CRLStoreSelector2, pKIXParameters).iterator();
                                                while (it5.hasNext()) {
                                                    try {
                                                        ASN1Primitive extensionValue3 = getExtensionValue((X509CRL) it5.next(), ISSUING_DISTRIBUTION_POINT);
                                                        if (extensionValue == null) {
                                                            if (extensionValue3 == null) {
                                                            }
                                                        } else if (extensionValue.equals(extensionValue3)) {
                                                        }
                                                    } catch (AnnotatedException e12) {
                                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.distrPtExtError"), e12);
                                                    }
                                                }
                                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noBaseCRL"));
                                            } catch (AnnotatedException e13) {
                                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlExtractionError"), e13);
                                            }
                                        } catch (AnnotatedException e14) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlNbrExtError"), e14);
                                        }
                                    } catch (IOException e15) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlIssuerException"), e15);
                                    }
                                }
                                if (extensionValue != null) {
                                    IssuingDistributionPoint issuingDistributionPoint = IssuingDistributionPoint.getInstance(extensionValue);
                                    try {
                                        BasicConstraints basicConstraints = BasicConstraints.getInstance(getExtensionValue(x509Certificate, BASIC_CONSTRAINTS));
                                        if (issuingDistributionPoint.onlyContainsUserCerts() && basicConstraints != null && basicConstraints.isCA()) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlOnlyUserCert"));
                                        }
                                        if (issuingDistributionPoint.onlyContainsCACerts() && (basicConstraints == null || !basicConstraints.isCA())) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlOnlyCaCert"));
                                        }
                                        if (issuingDistributionPoint.onlyContainsAttributeCerts()) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlOnlyAttrCert"));
                                        }
                                    } catch (AnnotatedException e16) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlBCExtError"), e16);
                                    }
                                }
                            } catch (AnnotatedException unused) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.deltaCrlExtError"));
                            }
                        } catch (AnnotatedException unused2) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.distrPtExtError"));
                        }
                    } catch (Exception e17) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlVerifyFailed"), e17);
                    }
                } else {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlNoIssuerPublicKey"));
                }
            }
            if (!z) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noValidCrlFound"));
            }
        } catch (IOException e18) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlIssuerException"), e18);
        }
    }

    protected Vector getCRLDistUrls(CRLDistPoint cRLDistPoint) {
        Vector vector = new Vector();
        if (cRLDistPoint != null) {
            for (DistributionPoint distributionPoint : cRLDistPoint.getDistributionPoints()) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2.getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].getTagNo() == 6) {
                            vector.add(((DERIA5String) names[i].getName()).getString());
                        }
                    }
                }
            }
        }
        return vector;
    }

    protected Vector getOCSPUrls(AuthorityInformationAccess authorityInformationAccess) {
        Vector vector = new Vector();
        if (authorityInformationAccess != null) {
            AccessDescription[] accessDescriptions = authorityInformationAccess.getAccessDescriptions();
            for (int i = 0; i < accessDescriptions.length; i++) {
                if (accessDescriptions[i].getAccessMethod().equals(AccessDescription.id_ad_ocsp)) {
                    GeneralName accessLocation = accessDescriptions[i].getAccessLocation();
                    if (accessLocation.getTagNo() == 6) {
                        vector.add(((DERIA5String) accessLocation.getName()).getString());
                    }
                }
            }
        }
        return vector;
    }

    private X509CRL getCRL(String str) throws Exception {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().equals("http") && !url.getProtocol().equals("https")) {
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return (X509CRL) CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME).generateCRL(httpURLConnection.getInputStream());
            }
            throw new Exception(httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.loadCrlDistPointError", new Object[]{new UntrustedInput(str), e.getMessage(), e, e.getClass().getName()}));
        }
    }

    protected Collection getTrustAnchors(X509Certificate x509Certificate, Set set) throws IOException, CertPathReviewerException {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            byte[] extensionValue = x509Certificate.getExtensionValue(Extension.authorityKeyIdentifier.getId());
            if (extensionValue != null) {
                AuthorityKeyIdentifier authorityKeyIdentifier = AuthorityKeyIdentifier.getInstance(ASN1Primitive.fromByteArray(((ASN1OctetString) ASN1Primitive.fromByteArray(extensionValue)).getOctets()));
                x509CertSelector.setSerialNumber(authorityKeyIdentifier.getAuthorityCertSerialNumber());
                byte[] keyIdentifier = authorityKeyIdentifier.getKeyIdentifier();
                if (keyIdentifier != null) {
                    x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(keyIdentifier).getEncoded());
                }
            }
            while (it.hasNext()) {
                TrustAnchor trustAnchor = (TrustAnchor) it.next();
                if (trustAnchor.getTrustedCert() != null) {
                    if (x509CertSelector.match(trustAnchor.getTrustedCert())) {
                        arrayList.add(trustAnchor);
                    }
                } else if (trustAnchor.getCAName() != null && trustAnchor.getCAPublicKey() != null && getEncodedIssuerPrincipal(x509Certificate).equals(new X500Principal(trustAnchor.getCAName()))) {
                    arrayList.add(trustAnchor);
                }
            }
            return arrayList;
        } catch (IOException unused) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustAnchorIssuerError"));
        }
    }
}
