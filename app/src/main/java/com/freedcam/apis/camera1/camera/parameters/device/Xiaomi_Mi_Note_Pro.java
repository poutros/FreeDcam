package com.freedcam.apis.camera1.camera.parameters.device;

import android.hardware.Camera;
import android.os.Handler;

import com.freedcam.apis.basecamera.camera.parameters.manual.AbstractManualParameter;
import com.freedcam.apis.basecamera.camera.parameters.modes.MatrixChooserParameter;
import com.freedcam.apis.camera1.camera.CameraHolderApi1;
import com.freedcam.apis.camera1.camera.CameraUiWrapper;
import com.freedcam.apis.camera1.camera.parameters.CamParametersHandler;
import com.troop.androiddng.DngProfile;

/**
 * Created by troop on 01.06.2016.
 */
public class Xiaomi_Mi_Note_Pro extends BaseQcomDevice {
    public Xiaomi_Mi_Note_Pro(Handler uihandler, Camera.Parameters parameters, CameraUiWrapper cameraUiWrapper) {
        super(uihandler, parameters, cameraUiWrapper);
    }

    @Override
    public DngProfile getDngProfile(int filesize)
    {
        switch (filesize)
        {
            case 17612800:
                return new DngProfile(64, 4212, 3120, DngProfile.Qcom, DngProfile.RGGB, 0,matrixChooserParameter.GetCustomMatrix(MatrixChooserParameter.NEXUS6));
            case 6721536:
                return new DngProfile(64,2592,1296,DngProfile.Qcom,DngProfile.BGGR,0, matrixChooserParameter.GetCustomMatrix(MatrixChooserParameter.NEXUS6));
            case 16560128:
                return new DngProfile(64, 4208, 3120, DngProfile.Mipi16, DngProfile.RGGB, 0,matrixChooserParameter.GetCustomMatrix(MatrixChooserParameter.NEXUS6));
        }
        return null;
    }
}