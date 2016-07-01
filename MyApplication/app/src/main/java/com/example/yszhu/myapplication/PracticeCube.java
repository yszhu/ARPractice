package com.example.yszhu.myapplication;

import android.opengl.GLES10;

import org.artoolkit.ar.base.rendering.RenderUtils;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by YSZhu on 2016/7/1.
 */
public class PracticeCube {
    private float rotate;
    private float Tx;
    private float Ty;
    private float Tz;

    public void setData(float romate,float x,float y,float z){
        this.rotate=romate;
        this.Tx=x;
        this.Ty=y;
        this.Tz=z;
    }
    private FloatBuffer mVertexBuffer;
    private FloatBuffer mColorBuffer;
    private ByteBuffer mIndexBuffer;

    public PracticeCube() {
        this(1.0f);
    }

    public PracticeCube(float size) {
        this(size, 0.0f, 0.0f, 0.0f);
    }

    public PracticeCube(float size, float x, float y, float z) {
        setArrays(size, x, y, z);
    }

    public FloatBuffer getmVertexBuffer() {
        return mVertexBuffer;
    }

    public FloatBuffer getmColorBuffer() {
        return mColorBuffer;
    }

    public ByteBuffer getmIndexBuffer() {
        return mIndexBuffer;
    }

    private void setArrays(float size, float x, float y, float z) {

        float hs = size / 2.0f;

        float vertices[] = {
                x - hs, y - hs, z - hs, // 0
                x + hs, y - hs, z - hs, // 1
                x + hs, y + hs, z - hs, // 2
                x - hs, y + hs, z - hs, // 3
                x - hs, y - hs, z + hs, // 4
                x + hs, y - hs, z + hs, // 5
                x + hs, y + hs, z + hs, // 6
                x - hs, y + hs, z + hs, // 7
        };

        float c = 1.0f;
        float colors[] = {
                0, 0, 0, c, // 0 black
                c, 0, 0, c, // 1 red
                c, c, 0, c, // 2 yellow
                0, c, 0, c, // 3 green
                0, 0, c, c, // 4 blue
                c, 0, c, c, // 5 magenta
                c, c, c, c, // 6 white
                0, c, c, c, // 7 cyan
        };

        byte indices[] = {
                0, 4, 5, 0, 5, 1,
                1, 5, 6, 1, 6, 2,
                2, 6, 7, 2, 7, 3,
                3, 7, 4, 3, 4, 0,
                4, 7, 6, 4, 6, 5,
                3, 0, 1, 3, 1, 2
        };


        mVertexBuffer = RenderUtils.buildFloatBuffer(vertices);
        mColorBuffer = RenderUtils.buildFloatBuffer(colors);
        mIndexBuffer = RenderUtils.buildByteBuffer(indices);

    }

    public void draw(GL10 gl) {


        /*GLES10.glColorPointer(4, GLES10.GL_FLOAT, 0, mColorBuffer);
        GLES10.glVertexPointer(3, GLES10.GL_FLOAT, 0, mVertexBuffer);

        GLES10.glEnableClientState(GLES10.GL_COLOR_ARRAY);
        GLES10.glEnableClientState(GLES10.GL_VERTEX_ARRAY);

        GLES10.glDrawElements(GLES10.GL_TRIANGLES, 36, GLES10.GL_UNSIGNED_BYTE, mIndexBuffer);

        GLES10.glDisableClientState(GLES10.GL_COLOR_ARRAY);
        GLES10.glDisableClientState(GLES10.GL_VERTEX_ARRAY);*/

        gl.glColorPointer(4, GLES10.GL_FLOAT, 0, mColorBuffer);
        gl.glVertexPointer(3, GLES10.GL_FLOAT, 0, mVertexBuffer);

        gl.glEnableClientState(GLES10.GL_COLOR_ARRAY);
        gl.glEnableClientState(GLES10.GL_VERTEX_ARRAY);

        gl.glRotatef((float)(rotate*3.14/180) ,Tx,Ty,Tz);

        gl.glDrawElements(GLES10.GL_TRIANGLES, 36, GLES10.GL_UNSIGNED_BYTE, mIndexBuffer);

        gl.glDisableClientState(GLES10.GL_COLOR_ARRAY);
        gl.glDisableClientState(GLES10.GL_VERTEX_ARRAY);

    }


}