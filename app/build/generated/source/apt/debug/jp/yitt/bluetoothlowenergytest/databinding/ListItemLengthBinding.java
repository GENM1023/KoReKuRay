package jp.yitt.bluetoothlowenergytest.databinding;
import jp.yitt.bluetoothlowenergytest.R;
import jp.yitt.bluetoothlowenergytest.BR;
import android.view.View;
public class ListItemLengthBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageButton, 4);
    }
    // views
    public final android.widget.ImageView imageButton;
    public final android.widget.TextView lengthDataDate;
    public final android.widget.TextView lengthDataLength;
    public final android.widget.TextView lengthDataTitle;
    private final android.widget.LinearLayout mboundView0;
    // variables
    private jp.yitt.bluetoothlowenergytest.model.LengthData mModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ListItemLengthBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.imageButton = (android.widget.ImageView) bindings[4];
        this.lengthDataDate = (android.widget.TextView) bindings[3];
        this.lengthDataDate.setTag(null);
        this.lengthDataLength = (android.widget.TextView) bindings[2];
        this.lengthDataLength.setTag(null);
        this.lengthDataTitle = (android.widget.TextView) bindings[1];
        this.lengthDataTitle.setTag(null);
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
                setModel((jp.yitt.bluetoothlowenergytest.model.LengthData) variable);
                return true;
        }
        return false;
    }

    public void setModel(jp.yitt.bluetoothlowenergytest.model.LengthData model) {
        this.mModel = model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }
    public jp.yitt.bluetoothlowenergytest.model.LengthData getModel() {
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
        jp.yitt.bluetoothlowenergytest.model.LengthData model = mModel;
        java.lang.String nameModel = null;
        java.lang.String timeModel = null;
        java.lang.String lengthModel = null;
        java.lang.String stringValueOfStringL = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (model != null) {
                    // read model.name
                    nameModel = model.getName();
                    // read model.time
                    timeModel = model.getTime();
                    // read model.length
                    lengthModel = model.getLength();
                }


                // read String.valueOf(model.length)
                stringValueOfStringL = java.lang.String.valueOf(lengthModel);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.lengthDataDate, timeModel);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.lengthDataLength, stringValueOfStringL);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.lengthDataTitle, nameModel);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ListItemLengthBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemLengthBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ListItemLengthBinding>inflate(inflater, jp.yitt.bluetoothlowenergytest.R.layout.list_item_length, root, attachToRoot, bindingComponent);
    }
    public static ListItemLengthBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemLengthBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(jp.yitt.bluetoothlowenergytest.R.layout.list_item_length, null, false), bindingComponent);
    }
    public static ListItemLengthBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ListItemLengthBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/list_item_length_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ListItemLengthBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}