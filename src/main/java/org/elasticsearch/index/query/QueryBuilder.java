/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.index.query;

import org.apache.lucene.search.Query;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.common.bytes.BytesReference;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * Base interface for all classes producing lucene queries.
 * Supports conversion to BytesReference and creation of lucene Query objects.
 */
public interface QueryBuilder extends ToXContent {

    BytesReference buildAsBytes() throws ElasticsearchException;

    BytesReference buildAsBytes(XContentType contentType) throws ElasticsearchException;

    /**
     * Create a {@link Query} based on this QueryBuilder
     * @param parseContext additional information needed to construct the queries
     * @return the {@link Query}
     * @throws QueryParsingException
     * @throws IOException
     */
    Query toQuery(QueryParseContext parseContext) throws QueryParsingException, IOException;
}
