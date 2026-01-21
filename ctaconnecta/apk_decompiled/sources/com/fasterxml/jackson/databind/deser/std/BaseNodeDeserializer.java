package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

/* compiled from: JsonNodeDeserializer.java */
/* loaded from: classes3.dex */
abstract class BaseNodeDeserializer<T extends JsonNode> extends StdDeserializer<T> {
    @Deprecated
    protected void _handleDuplicateField(String str, ObjectNode objectNode, JsonNode jsonNode, JsonNode jsonNode2) throws JsonProcessingException {
    }

    public BaseNodeDeserializer(Class<T> cls) {
        super((Class<?>) cls);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    protected void _reportProblem(JsonParser jsonParser, String str) throws JsonMappingException {
        throw new JsonMappingException(str, jsonParser.getTokenLocation());
    }

    protected void _handleDuplicateField(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, String str, ObjectNode objectNode, JsonNode jsonNode, JsonNode jsonNode2) throws JsonProcessingException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            _reportProblem(jsonParser, "Duplicate field '" + str + "' for ObjectNode: not allowed when FAIL_ON_READING_DUP_TREE_KEY enabled");
        }
        _handleDuplicateField(str, objectNode, jsonNode, jsonNode2);
    }

    protected final ObjectNode deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonNode jsonNodeDeserializeObject;
        JsonParser jsonParser2;
        DeserializationContext deserializationContext2;
        JsonNodeFactory jsonNodeFactory2;
        ObjectNode objectNode = jsonNodeFactory.objectNode();
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            currentToken = jsonParser.nextToken();
        }
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            int i = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonParser.nextToken().ordinal()];
            if (i == 1) {
                jsonNodeDeserializeObject = deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (i == 2) {
                jsonNodeDeserializeObject = deserializeArray(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (i == 3) {
                jsonNodeDeserializeObject = jsonNodeFactory.textNode(jsonParser.getText());
            } else {
                jsonNodeDeserializeObject = deserializeAny(jsonParser, deserializationContext, jsonNodeFactory);
            }
            JsonNode jsonNode = jsonNodeDeserializeObject;
            JsonNode jsonNodeReplace = objectNode.replace(currentName, jsonNode);
            if (jsonNodeReplace != null) {
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                jsonNodeFactory2 = jsonNodeFactory;
                _handleDuplicateField(jsonParser2, deserializationContext2, jsonNodeFactory2, currentName, objectNode, jsonNodeReplace, jsonNode);
            } else {
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                jsonNodeFactory2 = jsonNodeFactory;
            }
            currentToken = jsonParser2.nextToken();
            jsonParser = jsonParser2;
            deserializationContext = deserializationContext2;
            jsonNodeFactory = jsonNodeFactory2;
        }
        return objectNode;
    }

    /* compiled from: JsonNodeDeserializer.java */
    /* renamed from: com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$fasterxml$jackson$core$JsonToken = iArr;
            try {
                iArr[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.END_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.FIELD_NAME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NULL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    protected final ArrayNode deserializeArray(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        ArrayNode arrayNode = jsonNodeFactory.arrayNode();
        while (true) {
            JsonToken jsonTokenNextToken = jsonParser.nextToken();
            if (jsonTokenNextToken == null) {
                throw deserializationContext.mappingException("Unexpected end-of-input when binding data into ArrayNode");
            }
            int i = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonTokenNextToken.ordinal()];
            if (i == 1) {
                arrayNode.add(deserializeObject(jsonParser, deserializationContext, jsonNodeFactory));
            } else if (i == 2) {
                arrayNode.add(deserializeArray(jsonParser, deserializationContext, jsonNodeFactory));
            } else if (i == 3) {
                arrayNode.add(jsonNodeFactory.textNode(jsonParser.getText()));
            } else {
                if (i == 4) {
                    return arrayNode;
                }
                arrayNode.add(deserializeAny(jsonParser, deserializationContext, jsonNodeFactory));
            }
        }
    }

    protected final JsonNode deserializeAny(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[jsonParser.getCurrentToken().ordinal()]) {
            case 1:
            case 5:
                return deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
            case 2:
                return deserializeArray(jsonParser, deserializationContext, jsonNodeFactory);
            case 3:
                return jsonNodeFactory.textNode(jsonParser.getText());
            case 4:
            default:
                throw deserializationContext.mappingException(handledType());
            case 6:
                return deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
            case 7:
                Object embeddedObject = jsonParser.getEmbeddedObject();
                if (embeddedObject == null) {
                    return jsonNodeFactory.nullNode();
                }
                Class<?> cls = embeddedObject.getClass();
                if (cls == byte[].class) {
                    return jsonNodeFactory.binaryNode((byte[]) embeddedObject);
                }
                if (JsonNode.class.isAssignableFrom(cls)) {
                    return (JsonNode) embeddedObject;
                }
                return jsonNodeFactory.pojoNode(embeddedObject);
            case 8:
                JsonParser.NumberType numberType = jsonParser.getNumberType();
                if (numberType == JsonParser.NumberType.BIG_INTEGER || deserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                    return jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
                }
                if (numberType == JsonParser.NumberType.INT) {
                    return jsonNodeFactory.numberNode(jsonParser.getIntValue());
                }
                return jsonNodeFactory.numberNode(jsonParser.getLongValue());
            case 9:
                if (jsonParser.getNumberType() == JsonParser.NumberType.BIG_DECIMAL || deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return jsonNodeFactory.numberNode(jsonParser.getDecimalValue());
                }
                return jsonNodeFactory.numberNode(jsonParser.getDoubleValue());
            case 10:
                return jsonNodeFactory.booleanNode(true);
            case 11:
                return jsonNodeFactory.booleanNode(false);
            case 12:
                return jsonNodeFactory.nullNode();
        }
    }
}
