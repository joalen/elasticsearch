/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */

package org.elasticsearch.xpack.runtimefields.query;

import org.elasticsearch.script.Script;
import org.elasticsearch.xpack.runtimefields.StringScriptFieldScript;

import java.util.List;

public class StringScriptFieldExistsQuery extends AbstractStringScriptFieldQuery {
    public StringScriptFieldExistsQuery(Script script, StringScriptFieldScript.LeafFactory leafFactory, String fieldName) {
        super(script, leafFactory, fieldName);
    }

    @Override
    protected boolean matches(List<String> values) {
        return false == values.isEmpty();
    }

    @Override
    public final String toString(String field) {
        if (fieldName().contentEquals(field)) {
            return "ScriptFieldExists";
        }
        return fieldName() + ":ScriptFieldExists";
    }

    // Superclass's equals and hashCode are great for this class
}
