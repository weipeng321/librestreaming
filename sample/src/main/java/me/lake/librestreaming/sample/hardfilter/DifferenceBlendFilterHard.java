package me.lake.librestreaming.sample.hardfilter;

import android.graphics.Bitmap;

/**
 * Created by lake on 03/06/16.
 */
public class DifferenceBlendFilterHard extends TowInputFilterHard {
    protected String FRAGMENTSHADER = "" +
            "#extension GL_OES_EGL_image_external : require\n" +
            "precision mediump float;\n" +
            "varying mediump vec2 vCamTextureCoord;\n" +
            "varying mediump vec2 vImageTextureCoord;\n" +
            "uniform samplerExternalOES uCamTexture;\n" +
            "uniform sampler2D uImageTexture;\n" +
            "void main(){\n" +
            "   lowp vec4 c1 = texture2D(uCamTexture, vCamTextureCoord);\n" +
            "   lowp vec4 c2 = texture2D(uImageTexture, vImageTextureCoord);\n" +
            "   gl_FragColor = vec4(abs(c1.rgb - c2.rgb), 1.0f);\n" +
            "}";

    public DifferenceBlendFilterHard(Bitmap image) {
        super(image);
    }

    @Override
    public void onInit(int VWidth, int VHeight) {
        fragmentshader_filter = FRAGMENTSHADER;
        super.onInit(VWidth, VHeight);
    }
}
