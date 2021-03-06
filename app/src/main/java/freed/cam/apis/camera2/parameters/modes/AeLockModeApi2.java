package freed.cam.apis.camera2.parameters.modes;

import android.annotation.TargetApi;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;

import com.troop.freedcam.R;

import freed.cam.apis.basecamera.CameraWrapperInterface;
import freed.cam.apis.camera2.CameraHolderApi2;

/**
 * Created by Ingo on 03.10.2016.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class AeLockModeApi2 extends BaseModeApi2 {
    public AeLockModeApi2(CameraWrapperInterface cameraUiWrapper) {
        super(cameraUiWrapper);
    }

    @Override
    public boolean IsSupported() {
        return true;
    }


    @Override
    public String GetValue() {
        if (((CameraHolderApi2)cameraUiWrapper.getCameraHolder()).captureSessionHandler.get(CaptureRequest.CONTROL_AE_LOCK))
            return cameraUiWrapper.getResString(R.string.true_);
        else
            return cameraUiWrapper.getResString(R.string.false_);
    }

    @Override
    public String[] GetValues() {
        return new String[]{cameraUiWrapper.getResString(R.string.false_), cameraUiWrapper.getResString(R.string.true_)};
    }

    @Override
    public void SetValue(String valueToSet, boolean setToCamera) {
        if (valueToSet.equals(cameraUiWrapper.getResString(R.string.true_)))
            ((CameraHolderApi2)cameraUiWrapper.getCameraHolder()).captureSessionHandler.SetParameterRepeating(CaptureRequest.CONTROL_AE_LOCK,true);
        else
            ((CameraHolderApi2)cameraUiWrapper.getCameraHolder()).captureSessionHandler.SetParameterRepeating(CaptureRequest.CONTROL_AE_LOCK,false);
        //onValueHasChanged(valueToSet);
    }
}
