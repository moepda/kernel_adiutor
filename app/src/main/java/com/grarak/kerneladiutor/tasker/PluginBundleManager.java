/*
 * Copyright 2013 two forty four a.m. LLC <http://www.twofortyfouram.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * <http://www.apache.org/licenses/LICENSE-2.0>
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.grarak.kerneladiutor.tasker;

import android.os.Bundle;
import android.text.TextUtils;

import com.grarak.kerneladiutor.utils.Constants;

/**
 * Class for managing the {@link AddProfileActivity#EXTRA_BUNDLE} for this plug-in.
 */
public final class PluginBundleManager {
    /**
     * Type: {@code String}.
     * <p/>
     * String message to display in a Toast message.
     */
    public static final String BUNDLE_EXTRA_STRING_MESSAGE = "com.grarak.kerneladiutor.tasker.extra.STRING_MESSAGE"; //$NON-NLS-1$

    /**
     * Type: {@code int}.
     * <p/>
     * versionCode of the plug-in that saved the Bundle.
     */
    /*
     * This extra is not strictly required, however it makes backward and forward compatibility significantly
     * easier. For example, suppose a bug is found in how some version of the plug-in stored its Bundle. By
     * having the version, the plug-in can better detect when such bugs occur.
     */
    public static final String BUNDLE_EXTRA_INT_VERSION_CODE =
            "com.grarak.kerneladiutor.tasker.extra.INT_VERSION_CODE"; //$NON-NLS-1$

    /**
     * Method to verify the content of the bundle are correct.
     * <p/>
     * This method will not mutate {@code bundle}.
     *
     * @param bundle bundle to verify. May be null, which will always return false.
     * @return true if the Bundle is valid, false if the bundle is invalid.
     */
    public static boolean isBundleValid(Bundle bundle) {
        return null != bundle && !(!bundle.containsKey(BUNDLE_EXTRA_STRING_MESSAGE)
                || !bundle.containsKey(BUNDLE_EXTRA_INT_VERSION_CODE)) && !(2 != bundle.keySet().size()
                || TextUtils.isEmpty(bundle.getString(BUNDLE_EXTRA_STRING_MESSAGE)))
                && bundle.getInt(BUNDLE_EXTRA_INT_VERSION_CODE, 0) == bundle.getInt(BUNDLE_EXTRA_INT_VERSION_CODE, 1);

    }

    /**
     * @param message The toast message to be displayed by the plug-in. Cannot be null.
     * @return A plug-in bundle.
     */
    public static Bundle generateBundle(String message) {
        final Bundle result = new Bundle();
        result.putInt(BUNDLE_EXTRA_INT_VERSION_CODE, Constants.VERSION_CODE);
        result.putString(BUNDLE_EXTRA_STRING_MESSAGE, message);

        return result;
    }

    /**
     * Private constructor prevents instantiation
     *
     * @throws UnsupportedOperationException because this class cannot be instantiated.
     */
    private PluginBundleManager() {
        throw new UnsupportedOperationException("This class is non-instantiable"); //$NON-NLS-1$
    }
}
