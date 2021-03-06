/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.drools.workbench.verifier.webworker.client;

import com.google.gwtmockito.GwtMockitoTestRunner;
import org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52;
import org.drools.workbench.services.verifier.api.client.Status;
import org.drools.workbench.services.verifier.api.client.configuration.RunnerType;
import org.drools.workbench.services.verifier.api.client.reporting.Issues;
import org.drools.workbench.services.verifier.plugin.client.api.Initialize;
import org.drools.workbench.services.verifier.plugin.client.builders.ModelMetaDataEnhancer;
import org.drools.workbench.verifier.webworker.client.testutil.AnalyzerProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

@RunWith(GwtMockitoTestRunner.class)
public class ReceiverTest {

    protected AnalyzerProvider analyzerProvider;

    @Mock
    private Poster poster;

    @Captor
    private ArgumentCaptor<Status> statusArgumentCaptor;

    @Captor
    private ArgumentCaptor<Issues> issuesArgumentCaptor;

    private Receiver receiver;

    @Before
    public void setUp() throws
                        Exception {

        analyzerProvider = new AnalyzerProvider();

        receiver = new Receiver( poster,
                                 RunnerType.JAVA );
    }

    @Test
    public void testInit() throws
                           Exception {

        final GuidedDecisionTable52 table1 = analyzerProvider.makeAnalyser()
                .withPersonAgeColumn( ">" )
                .withPersonApprovedActionSetField()
                .withData( DataBuilderProvider
                                   .row( 0,
                                         true )
                                   .end() )
                .buildTable();

        receiver.received( new Initialize( "testUUID",
                                           table1,
                                           new ModelMetaDataEnhancer( table1 ).getHeaderMetaData(),
                                           analyzerProvider.getFactTypes(),
                                           "dd-MMM-yyyy" ) );

        verify( poster ).post( issuesArgumentCaptor.capture() );
    }
}