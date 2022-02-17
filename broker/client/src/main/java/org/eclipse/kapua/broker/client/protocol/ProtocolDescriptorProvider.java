/*******************************************************************************
 * Copyright (c) 2017, 2022 Red Hat Inc and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.broker.client.protocol;

/**
 * A provider for {@link ProtocolDescriptor} instances
 */
public interface ProtocolDescriptorProvider {

    /**
     * Get a {@link ProtocolDescriptor} for the given transport name
     *
     * @param connectorName
     *            The name of the connector to lookup
     * @return The connector descriptor, or {@code null} if this provider could not find one
     */
    public ProtocolDescriptor getDescriptor(String connectorName);
}
