/* Copyright (c) 2010 Zhihua (Dennis) Jiang
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

package com.touchonmobile.gwtmobile.phonegap.kitchensink.client;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.touchonmobile.gwtmobile.phonegap.client.Device;
import com.touchonmobile.gwtmobile.phonegap.client.Event;
import com.touchonmobile.gwtmobile.phonegap.client.Event.Callback;

public class EventUi extends Composite {

	private static EventUiUiBinder uiBinder = GWT.create(EventUiUiBinder.class);
	
	@UiField TextArea text;

	interface EventUiUiBinder extends UiBinder<Widget, EventUi> {
	}

	public EventUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		
		Device.overrideBackButton();
		
		Event.onDeviceReady(new Callback() {			
			@Override
			public void onEventFired() {
				text.setText((new Date()).toString() + ": onDeviceReady\n" + text.getText());
			}
		});
		
		Event.onPause(new Callback() {			
			@Override
			public void onEventFired() {
				text.setText((new Date()).toString() + ": onPause\n" + text.getText());
			}
		});

		Event.onResume(new Callback() {			
			@Override
			public void onEventFired() {
				text.setText((new Date()).toString() + ": onResume\n" + text.getText());
			}
		});

		Event.onBackKeyDown(new Callback() {			
			@Override
			public void onEventFired() {
				text.setText((new Date()).toString() + ": onBackKeyDown\n" + text.getText());
			}
		});

		Event.onMenuKeyDown(new Callback() {			
			@Override
			public void onEventFired() {
				text.setText((new Date()).toString() + ": onMenuKeyDown\n" + text.getText());
			}
		});
		
		Event.onSearchKeyDown(new Callback() {			
			@Override
			public void onEventFired() {
				text.setText((new Date()).toString() + ": onSearchKeyDown\n" + text.getText());
			}
		});
		
	}
	
	@Override
	protected void onUnload() {
		super.onUnload();
		Device.resetBackButton();
	}

}
