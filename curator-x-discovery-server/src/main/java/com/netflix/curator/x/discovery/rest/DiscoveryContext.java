/*
 *
 *  Copyright 2011 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.netflix.curator.x.discovery.rest;

import com.netflix.curator.x.discovery.ServiceDiscovery;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

/**
 * Bridge between the specifics of your needs and the generic implementation
 */
public interface DiscoveryContext<T>
{
    /**
     * Return the threshold in milliseconds to consider a registration stale
     *
     * @return number of milliseconds
     */
    public int                      getInstanceRefreshMs();

    /**
     * Return the service singleton
     *
     * @return service
     */
    public ServiceDiscovery<T>      getServiceDiscovery();

    /**
     * Serialize your payload
     *
     * @param node the node to serialize into
     * @param fieldName field name to use
     * @param payload the payload value (can be null)
     * @throws Exception any errors
     */
    public void                     marshallJson(ObjectNode node, String fieldName, T payload) throws Exception;

    /**
     * Deserialize your payload
     *
     * @param node the node that has the payload
     * @return the payload or null
     * @throws Exception any errors
     */
    public T                        unMarshallJson(JsonNode node) throws Exception;
}
