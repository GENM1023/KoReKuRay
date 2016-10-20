package jp.yitt.bluetoothlowenergytest.databinding;
import jp.yitt.bluetoothlowenergytest.R;
import jp.yitt.bluetoothlowenergytest.BR;
import android.view.View;
public class FragmentMeasurementBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.statusTitleTextView, 4);
        sViewsWithIds.put(R.id.lengthTextView, 5);
        sViewsWithIds.put(R.id.unitTextView, 6);
        sViewsWithIds.put(R.id.measuredList, 7);
    }
    // views
    public final android.widget.RelativeLayout RootView;
    public final android.widget.Button eraseButton;
    public final android.widget.TextView lengthTextView;
    public final android.widget.ListView measuredList;
    public final android.widget.Button saveButton;
    public final android.widget.TextView statusTitleTextView;
    public final android.widget.ImageView unitChangeButton;
    public final android.widget.TextView unitTextView;
    // variables
    private jp.yitt.bluetoothlowenergytest.MeasurementFragment mFragment;
    // values
    // listeners
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private OnClickListenerImpl1 mAndroidViewViewOnCl1;
    private OnClickListenerImpl2 mAndroidViewViewOnCl2;
    // Inverse Binding Event Handlers

    public FragmentMeasurementBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.RootView = (android.widget.RelativeLayout) bindings[0];
        this.RootView.setTag(null);
        this.eraseButton = (android.widget.Button) bindings[2];
        this.eraseButton.setTag(null);
        this.lengthTextView = (android.widget.TextView) bindings[5];
        this.measuredList = (android.widget.ListView) bindings[7];
        this.saveButton = (android.widget.Button) bindings[1];
        this.saveButton.setTag(null);
        this.statusTitleTextView = (android.widget.TextView) bindings[4];
        this.unitChangeButton = (android.widget.ImageView) bindings[3];
        this.unitChangeButton.setTag(null);
        this.unitTextView = (android.widget.TextView) bindings[6];
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
            case BR.fragment :
                setFragment((jp.yitt.bluetoothlowenergytest.MeasurementFragment) variable);
                return true;
        }
        return false;
    }

    public void setFragment(jp.yitt.bluetoothlowenergytest.MeasurementFragment fragment) {
        this.mFragment = fragment;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.fragment);
        super.requestRebind();
    }
    public jp.yitt.bluetoothlowenergytest.MeasurementFragment getFragment() {
        return mFragment;
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
        android.view.View.OnClickListener androidViewViewOnCli = null;
        jp.yitt.bluetoothlowenergytest.MeasurementFragment fragment = mFragment;
        android.view.View.OnClickListener androidViewViewOnCli1 = null;
        android.view.View.OnClickListener androidViewViewOnCli2 = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (fragment != null) {
                    // read fragment::eraseDatas
                    androidViewViewOnCli = (((mAndroidViewViewOnCl == null) ? (mAndroidViewViewOnCl = new OnClickListenerImpl()) : mAndroidViewViewOnCl).setValue(fragment));
                    // read fragment::unitChange
                    androidViewViewOnCli1 = (((mAndroidViewViewOnCl1 == null) ? (mAndroidViewViewOnCl1 = new OnClickListenerImpl1()) : mAndroidViewViewOnCl1).setValue(fragment));
                    // read fragment::saveDatas
                    androidViewViewOnCli2 = (((mAndroidViewViewOnCl2 == null) ? (mAndroidViewViewOnCl2 = new OnClickListenerImpl2()) : mAndroidViewViewOnCl2).setValue(fragment));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.eraseButton.setOnClickListener(androidViewViewOnCli);
            this.saveButton.setOnClickListener(androidViewViewOnCli2);
            this.unitChangeButton.setOnClickListener(androidViewViewOnCli1);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private jp.yitt.bluetoothlowenergytest.MeasurementFragment value;
        public OnClickListenerImpl setValue(jp.yitt.bluetoothlowenergytest.MeasurementFragment value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.eraseDatas(arg0);
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private jp.yitt.bluetoothlowenergytest.MeasurementFragment value;
        public OnClickListenerImpl1 setValue(jp.yitt.bluetoothlowenergytest.MeasurementFragment value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.unitChange(arg0);
        }
    }
    public static class OnClickListenerImpl2 implements android.view.View.OnClickListener{
        private jp.yitt.bluetoothlowenergytest.MeasurementFragment value;
        public OnClickListenerImpl2 setValue(jp.yitt.bluetoothlowenergytest.MeasurementFragment value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.saveDatas(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static FragmentMeasurementBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentMeasurementBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentMeasurementBinding>inflate(inflater, jp.yitt.bluetoothlowenergytest.R.layout.fragment_measurement, root, attachToRoot, bindingComponent);
    }
    public static FragmentMeasurementBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentMeasurementBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(jp.yitt.bluetoothlowenergytest.R.layout.fragment_measurement, null, false), bindingComponent);
    }
    public static FragmentMeasurementBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentMeasurementBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_measurement_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentMeasurementBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): fragment
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}