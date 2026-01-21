package org.jsoup.nodes;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

/* loaded from: classes6.dex */
public class FormElement extends Element {
    private final Elements elements;

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
        this.elements = new Elements();
    }

    public Elements elements() {
        return this.elements;
    }

    public FormElement addElement(Element element) {
        this.elements.add(element);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    protected void removeChild(Node node) {
        super.removeChild(node);
        this.elements.remove(node);
    }

    public Connection submit() {
        String strAbsUrl = hasAttr("action") ? absUrl("action") : baseUri();
        Validate.notEmpty(strAbsUrl, "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
        return Jsoup.connect(strAbsUrl).data(formData()).method(attr(FirebaseAnalytics.Param.METHOD).toUpperCase().equals("POST") ? Connection.Method.POST : Connection.Method.GET);
    }

    public List<Connection.KeyVal> formData() {
        Element elementFirst;
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = this.elements.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next.tag().isFormSubmittable() && !next.hasAttr("disabled")) {
                String strAttr = next.attr(AppMeasurementSdk.ConditionalUserProperty.NAME);
                if (strAttr.length() != 0) {
                    String strAttr2 = next.attr("type");
                    if ("select".equals(next.tagName())) {
                        Iterator<Element> it2 = next.select("option[selected]").iterator();
                        boolean z = false;
                        while (it2.hasNext()) {
                            arrayList.add(HttpConnection.KeyVal.create(strAttr, it2.next().val()));
                            z = true;
                        }
                        if (!z && (elementFirst = next.select("option").first()) != null) {
                            arrayList.add(HttpConnection.KeyVal.create(strAttr, elementFirst.val()));
                        }
                    } else if ("checkbox".equalsIgnoreCase(strAttr2) || "radio".equalsIgnoreCase(strAttr2)) {
                        if (next.hasAttr("checked")) {
                            arrayList.add(HttpConnection.KeyVal.create(strAttr, next.val().length() > 0 ? next.val() : DebugKt.DEBUG_PROPERTY_VALUE_ON));
                        }
                    } else {
                        arrayList.add(HttpConnection.KeyVal.create(strAttr, next.val()));
                    }
                }
            }
        }
        return arrayList;
    }
}
