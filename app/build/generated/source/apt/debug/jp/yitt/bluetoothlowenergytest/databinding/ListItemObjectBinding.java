package jp.yitt.bluetoothlowenergytest.databinding;
import jp.yitt.bluetoothlowenergytest.R;
import jp.yitt.bluetoothlowenergytest.BR;
import android.view.View;
public class ListItemObjectBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageButton, 4);
        sViewsWithIds.put(R.id.cubeDataTitle, 5);
        sViewsWithIds.put(R.id.cubeDataDate, 6);
    }
    // views
    public final android.widget.TextView cubeDataDate;
    public final android.widget.TextView cubeDataHeight;
    public final android.widget.TextView cubeDataLength;
    public final android.widget.TextView cubeDataTitle;
    public final android.widget.TextView cubeDataWidth;
    public final android.widget.ImageView imageButton;
    private final android.widget.LinearLayout mboundView0;
    // variables
    private jp.yitt.bluetoothlowenergytest.model.CubeData mModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ListItemObjectBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.cubeDataDate = (android.widget.TextView) bindings[6];
        this.cubeDataHeight = (android.widget.TextView) bindings[1];
        this.cubeDataHeight.setTag(null);
        this.cubeDataLength = (android.widget.TextView) bindings[3];
        this.cubeDataLength.setTag(null);
        this.cubeDataTitle = (android.widget.TextView) bindings[5];
        this.cubeDataWidth = (android.widget.TextView) bindings[2];
        this.cubeDataWidth.setTag(null);
        this.imageButton = (android.widget.ImageView) bindings[4];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.model :
                setModel((jp.yitt.bluetoothlowenergytest.model.CubeData) variable);
                return true;
        }
        return false;
    }

    public void setModel(jp.yitt.bluetoothlowenergytest.model.CubeData model) {
        this.mModel = model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }
    public jp.yitt.bluetoothlowenergytest.model.CubeData getModel() {
        return mModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        jp.yitt.bluetoothlowenergytest.model.CubeData model = mModel;
        double heightModel = 0.0;
        java.lang.String stringValueOfStringH = null;
        double widthModel = 0.0;
        double lengthModel = 0.0;
        java.lang.String stringValueOfStringW = null;
        java.lang.String stringValueOfStringL = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (model != null) {
                    // read model.height
                    heightModel = model.getHeight();
                    // read model.width
                    widthModel = model.getWidth();
                    // read model.length
                    lengthModel = model.getLength();
                }


                // read String.valueOf(model.height)
                stringValueOfStringH = java.lang.String.valueOf(heightModel);
                // read String.valueOf(model.width)
                stringValueOfStringW = java.lang.String.valueOf(widthModel);
                // read String.valueOf(model.length)
                stringValueOfStringL = java.lang.String.valueOf(lengthModel);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.cubeDataHeight, stringValueOfStringH);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.cubeDataLength, stringValueOfStringL);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.cubeDataWidth, stringValueOfStringW);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ListItemObjectBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemObjectBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ListItemObjectBinding>inflate(inflater, jp.yitt.bluetoothlowenergytest.R.layout.list_item_object, root, attachToRoot, bindingComponent);
    }
    public static ListItemObjectBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemObjectBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(jp.yitt.bluetoothlowenergytest.R.layout.list_item_object, null, false), bindingComponent);
    }
    public static ListItemObjectBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemObjectBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/list_item_object_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ListItemObjectBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}