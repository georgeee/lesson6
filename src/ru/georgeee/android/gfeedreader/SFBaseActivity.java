/*
 * Copyright (C) 2013 Alexander Osmanov (http://perfectear.educkapps.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package ru.georgeee.android.gfeedreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class SFBaseActivity extends FragmentActivity implements SFServiceCallbackListener {

    private SFServiceHelper serviceHelper;

    protected SFApplication getApp() {
        return (SFApplication) getApplication();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceHelper = getApp().getServiceHelper();
    }

    @Override
    protected void onResume() {
        super.onResume();
        serviceHelper.addListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        serviceHelper.removeListener(this);
    }

    public SFServiceHelper getServiceHelper() {
        return serviceHelper;
    }

    /**
     * Called when a service request finishes executing.
     *
     * @param requestId  original request id
     * @param requestIntent   request data
     * @param resultCode result of execution code
     * @param resultData result data
     */
    @Override
    public void onServiceCallback(int requestId, Intent requestIntent, int resultCode, Bundle resultData) {
    }

}
