/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.workbench.services.verifier.api.client.reporting;

import java.util.Set;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class ValueForActionIsSetTwiceIssue
        extends Issue {

    private String firstItem;
    private final String secondItem;

    public ValueForActionIsSetTwiceIssue( @MapsTo("severity") final Severity severity,
                                          @MapsTo("explanationType") final ExplanationType explanationType,
                                          @MapsTo("firstItem") final String firstItem,
                                          @MapsTo("secondItem") final String secondItem,
                                          @MapsTo("rowNumbers") final Set<Integer> rowNumbers ) {
        super( severity,
               explanationType,
               rowNumbers );

        this.firstItem = firstItem;
        this.secondItem = secondItem;
    }

    public String getFirstItem() {
        return firstItem;
    }

    public String getSecondItem() {
        return secondItem;
    }
}
