package com.awshack.ezraerani.greenhousemonitor;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;


public class ItemTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);

        return new TypeAdapter<T>() {

            public void write(JsonWriter out, T value) throws IOException {
                delegate.write(out, value);
            }

            // Make the element that's returned just the list of returned items
            public T read(JsonReader in) throws IOException {
                JsonElement jsonElement = elementAdapter.read(in);
                if (jsonElement.isJsonObject()) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.has("results")) {
                        JsonArray jsonArray = jsonObject.getAsJsonArray("results");
                        jsonElement = jsonArray;
                    } else if (jsonObject.has("cast")) {
                        JsonArray jsonArray = jsonObject.getAsJsonArray("cast");
                        jsonElement = jsonArray;
                    }

                }
                return delegate.fromJsonTree(jsonElement);
            }

        }.nullSafe();
    }
}
