package jp.yitt.bluetoothlowenergytest.databinding;
import jp.yitt.bluetoothlowenergytest.R;
import jp.yitt.bluetoothlowenergytest.BR;
import android.view.View;
public class ListItemAreaBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageButton, 5);
    }
    // views
    public final android.widget.TextView areaDataDate;
    public final android.widget.TextView areaDataHeight;
    public final android.widget.TextView areaDataTitle;
    public final android.widget.TextView areaDataWidth;
    public final android.widget.ImageView imageButton;
    private final android.widget.LinearLayout mboundView0;
    // variables
    private jp.yitt.bluetoothlowenergytest.model.AreaData mModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ListItemAreaBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.areaDataDate = (android.widget.TextView) bindings[4];
        this.areaDataDate.setTag(null);
        this.areaDataHeight = (android.widget.TextView) bindings[2];
        this.areaDataHeight.setTag(null);
        this.areaDataTitle = (android.widget.TextView) bindings[1];
        this.areaDataTitle.setTag(null);
        this.areaDataWidth = (android.widget.TextView) bindings[3];
        this.areaDataWidth.setTag(null);
        this.imageButton = (android.widget.ImageView) bindings[5];
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
                setModel((jp.yitt.bluetoothlowenergytest.model.AreaData) variable);
                return true;
        }
        return false;
    }

    public void setModel(jp.yitt.bluetoothlowenergytest.model.AreaData model) {
        this.mModel = model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }
    public jp.yitt.bluetoothlowenergytest.model.AreaData getModel() {
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
        jp.yitt.bluetoothlowenergytest.model.AreaData model = mModel;
        java.lang.String nameModel = null;
        double heightModel = 0.0;
        java.lang.String timeModel = null;
        java.lang.String stringValueOfStringH = null;
        double widthModel = 0.0;
        java.lang.String stringValueOfStringW = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (model != null) {
                    // read model.name
                    nameModel = model.getName();
                    // read model.height
                    heightModel = model.getHeight();
                    // read model.time
                    timeModel = model.getTime();
                    // read model.width
                    widthModel = model.getWidth();
                }


                // read String.valueOf(model.height)
                stringValueOfStringH = java.lang.String.valueOf(heightModel);
                // read String.valueOf(model.width)
                stringValueOfStringW = java.lang.String.valueOf(widthModel);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.areaDataDate, timeModel);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.areaDataHeight, stringValueOfStringH);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.areaDataTitle, nameModel);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.areaDataWidth, stringValueOfStringW);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ListItemAreaBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemAreaBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ListItemAreaBinding>inflate(inflater, jp.yitt.bluetoothlowenergytest.R.layout.list_item_area, root, attachToRoot, bindingComponent);
    }
    public static ListItemAreaBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemAreaBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(jp.yitt.bluetoothlowenergytest.R.layout.list_item_area, null, false), bindingComponent);
    }
    public static ListItemAreaBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemAreaBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/list_item_area_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ListItemAreaBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}