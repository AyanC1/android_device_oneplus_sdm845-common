/*
* Copyright (C) 2018 The OmniROM Project
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*
*/
package org.omnirom.camerapackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;

import vendor.oneplus.camera.CameraHIDL.V1_0.IOnePlusCameraProvider;

public class Startup extends BroadcastReceiver {

    private static final String TAG = "IOnePlusCameraProvider";
    private IOnePlusCameraProvider mProvider;

    @Override
    public void onReceive(final Context context, final Intent bootintent) {
        try {
            mProvider = new IOnePlusCameraProvider();
            mProvider.setPackageName();
        } catch (RemoteException e) {
            Log.e(TAG, "setPackageName error", e);
        }
    }
}
