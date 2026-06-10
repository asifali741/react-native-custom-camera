package com.customcamera

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.modules.core.PermissionAwareActivity
import com.facebook.react.modules.core.PermissionListener

class CustomCameraModule(
  reactContext: ReactApplicationContext
) : NativeCustomCameraSpec(reactContext), PermissionListener {

  private var pendingPromise: Promise? = null

  @ReactMethod
  override fun openCamera(promise: Promise) {
    val activity: Activity? = reactApplicationContext.currentActivity

    if (activity == null) {
      promise.reject("NO_ACTIVITY", "Activity not available")
      return
    }

    if (activity.checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
      launchCamera(activity, promise)
      return
    }

    if (activity !is PermissionAwareActivity) {
      promise.reject("PERMISSION_ERROR", "Current activity cannot request camera permission")
      return
    }

    pendingPromise = promise
    activity.requestPermissions(
      arrayOf(Manifest.permission.CAMERA),
      CAMERA_PERMISSION_REQUEST,
      this
    )
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<String>,
    grantResults: IntArray,
  ): Boolean {
    if (requestCode != CAMERA_PERMISSION_REQUEST) {
      return false
    }

    val promise = pendingPromise ?: return true
    pendingPromise = null

    if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
      promise.reject("PERMISSION_DENIED", "Camera permission denied")
      return true
    }

    val activity = reactApplicationContext.currentActivity
    if (activity == null) {
      promise.reject("NO_ACTIVITY", "Activity not available")
      return true
    }

    launchCamera(activity, promise)
    return true
  }

  private fun launchCamera(activity: Activity, promise: Promise) {
    try {
      val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
      activity.startActivity(intent)
      promise.resolve("opened")
    } catch (exception: ActivityNotFoundException) {
      promise.reject("NO_CAMERA_APP", "No camera app available", exception)
    } catch (exception: SecurityException) {
      promise.reject("CAMERA_PERMISSION_ERROR", "Permission denied while opening camera", exception)
    } catch (exception: RuntimeException) {
      promise.reject("CAMERA_ERROR", "Unable to open camera", exception)
    }
  }

  companion object {
    private const val CAMERA_PERMISSION_REQUEST = 101
    const val NAME = NativeCustomCameraSpec.NAME
  }
}
