/**
 * @PROJECT.FULLNAME@ @VERSION@ License.
 *
 * Copyright @YEAR@ L2FProd.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package javax.swing.plaf.synth;

import javax.swing.JComponent;
import javax.swing.UIDefaults;
import javax.swing.plaf.ComponentUI;

import com.l2fprod.skinbuilder.Log;

/**
 * APatchedSynthLookAndFeel. <br>
 * 
 */
public class APatchedSynthLookAndFeel extends SynthLookAndFeel
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public UIDefaults getDefaults() {
        UIDefaults defaults = super.getDefaults();
        defaults.put("InternalFrameUI", APatchedSynthLookAndFeel.class.getName());
        return defaults;
    }

    public static ComponentUI createUI(JComponent c) {
        String key = c.getUIClassID().intern();
        Log.OUT.info("createUI(" + key + ")");
        try {
            if (key == "InternalFrameUI") {
                return APatchedSynthInternalFrameUI.createUI(c);
            } else {
                return SynthLookAndFeel.createUI(c);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        } catch (Error e) {
            e.printStackTrace();
            throw e;
        }
    }

}
