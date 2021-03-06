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

package org.drools.workbench.screens.guided.dtable.client.editor.menu;

import com.google.gwt.user.client.ui.HasEnabled;
import org.drools.workbench.screens.guided.dtable.client.widget.table.GuidedDecisionTableModellerView;

public interface InsertMenuView extends BaseMenuView<InsertMenuBuilder>,
                                        HasEnabled {

    interface Presenter extends BaseMenuView.BaseMenuPresenter {

        void setModeller( final GuidedDecisionTableModellerView.Presenter modeller );

        void onAppendRow();

        void onInsertRowAbove();

        void onInsertRowBelow();

        void onAppendColumn();

    }

    void enableAppendRowMenuItem( final boolean enabled );

    void enableInsertRowAboveMenuItem( final boolean enabled );

    void enableInsertRowBelowMenuItem( final boolean enabled );

    void enableAppendColumnMenuItem( final boolean enabled );

}
