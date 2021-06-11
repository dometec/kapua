/*******************************************************************************
 * Copyright (c) 2021 Eurotech and/or its affiliates and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.translator.kura.kapua.keystore;

import org.eclipse.kapua.service.device.call.kura.model.keystore.KuraKeystoreItem;
import org.eclipse.kapua.service.device.call.message.kura.app.response.KuraResponseMessage;
import org.eclipse.kapua.service.device.call.message.kura.app.response.KuraResponsePayload;
import org.eclipse.kapua.service.device.management.keystore.message.internal.response.KeystoreItemResponseMessage;
import org.eclipse.kapua.service.device.management.keystore.message.internal.response.KeystoreResponsePayload;
import org.eclipse.kapua.translator.exception.InvalidPayloadException;

/**
 * {@link org.eclipse.kapua.translator.Translator} implementation from {@link KuraResponseMessage} to {@link KeystoreItemResponseMessage}
 *
 * @since 1.5.0
 */
public class TranslatorAppKeystoreItemKuraKapua extends AbstractTranslatorAppKeystoreKuraKapua<KeystoreItemResponseMessage> {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public TranslatorAppKeystoreItemKuraKapua() {
        super(KeystoreItemResponseMessage.class);
    }

    @Override
    protected KeystoreResponsePayload translatePayload(KuraResponsePayload kuraResponsePayload) throws InvalidPayloadException {
        try {
            KeystoreResponsePayload keystoreResponsePayload = super.translatePayload(kuraResponsePayload);

            if (kuraResponsePayload.hasBody()) {
                KuraKeystoreItem kuraKeystoreItem = readJsonBodyAs(kuraResponsePayload.getBody(), KuraKeystoreItem.class);

                keystoreResponsePayload.setKeystoreItem(translate(kuraKeystoreItem));
            }

            return keystoreResponsePayload;
        } catch (Exception e) {
            throw new InvalidPayloadException(e, kuraResponsePayload);
        }
    }
}
