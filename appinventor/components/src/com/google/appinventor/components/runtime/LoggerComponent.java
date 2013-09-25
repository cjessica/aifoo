package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;

/**
 * Sensor that can measure absolute orientation in 3 dimensions.
 *
 */
@DesignerComponent(version = 1, //This should be a reference to YaVersion.java
    description = "<p>Non-visible component providing logging functions<br>" +
        "This is a test Component.</p>",
    category = ComponentCategory.BASIC,
    nonVisible = true,
    iconName = "images/logger.png")

@SimpleObject
public class LoggerComponent extends AndroidNonvisibleComponent
    implements OnPauseListener {
  // Constants
  private static final String LOG_TAG = "LoggerComponent";

  // Properties
  private boolean enabled;

  /**
   * Creates a new OrientationSensor component.
   *
   * @param container  ignored (because this is a non-visible component)
   */
  public LoggerComponent(ComponentContainer container) {
    super(container.$form());

    // Register for onPause() event.
    form.registerForOnPause(this);

    // Set default property values.
    Enabled(true);
  }

  // Properties
  /**
   * Enabled property getter method.
   *
   * @return {@code true} indicates that the sensor generates events,
   *         {@code false} that it doesn't
   */
  @SimpleProperty(category = PropertyCategory.BEHAVIOR)
  public boolean Enabled() {
    return enabled;
  }

  /**
   * Enabled property setter method.
   *
   * @param enabled  {@code true} enables logging
   *                 {@code false} disables it
   */
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN,
      defaultValue = "True")
  @SimpleProperty
  public void Enabled(boolean enabled) {
    if (this.enabled != enabled) {
      this.enabled = enabled;
    }
  }

  // OnPauseListener implementation
  public void onPause() {
    if (Enabled()){
      Log.d(LOG_TAG, "I got onPause and my Logger Component was ENABLED?!!!");
    }
    else {
      Log.d(LOG_TAG, "I got onPause and my Logger Component!!!");
    }
  }
  
  //OnPauseListener implementation
 public void onResume() {
   if (Enabled()){
     Log.d(LOG_TAG, "I got onResume and my Logger Component was ENABLED?!!!");
   }
   else {
     Log.d(LOG_TAG, "I got onResume and my Logger Component!!!");
   }
 }
}

