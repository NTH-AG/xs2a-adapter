/*
 * Copyright 2018-2018 adorsys GmbH & Co KG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.adorsys.xs2a.adapter.service.impl;

import de.adorsys.xs2a.adapter.adapter.BasePaymentInitiationService;

import java.util.AbstractMap;
import java.util.Map;

public class VerlagPaymentInitiationService extends BasePaymentInitiationService {

    private AbstractMap.SimpleImmutableEntry<String, String> apiKey;

    public VerlagPaymentInitiationService(String baseUri, AbstractMap.SimpleImmutableEntry<String, String> apiKey) {
        super(baseUri);
        this.apiKey = apiKey;
    }

    @Override
    protected Map<String, String> populatePostHeaders(Map<String, String> map) {
        addApiKey(map);
        return map;
    }

    @Override
    protected Map<String, String> populatePutHeaders(Map<String, String> headers) {
        addApiKey(headers);
        return headers;
    }

    @Override
    protected Map<String, String> populateGetHeaders(Map<String, String> headers) {
        addApiKey(headers);
        return headers;
    }

    private void addApiKey(Map<String, String> headers) {
        headers.put(apiKey.getKey(), apiKey.getValue());
    }
}
