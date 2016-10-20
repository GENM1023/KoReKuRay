package jp.yitt.bluetoothlowenergytest.databinding;
import jp.yitt.bluetoothlowenergytest.R;
import jp.yitt.bluetoothlowenergytest.BR;
import android.view.View;
public class FragmentMainBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.mainListView, 2);
        sViewsWithIds.put(R.id.multiple_actions, 3);
    }
    // views
    public final com.getbase.floatingactionbutton.FloatingActionButton actionLength;
    public final android.widget.ListView mainListView;
    private final android.widget.RelativeLayout mboundView0;
    public final com.getbase.floatingactionbutton.FloatingActionsMenu multipleActions;
    // variables
    private jp.yitt.bluetoothlowenergytest.MainFragment mFragment;
    // values
    // listeners
    private OnClickListenerImpl mAndroidViewViewOnCl;
    // Inverse Binding Event Handlers

    public FragmentMainBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.actionLength = (com.getbase.floatingactionbutton.FloatingActionButton) bindings[1];
        this.actionLength.setTag(null);
        this.mainListView = (android.widget.ListView) bindings[2];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.multipleActions = (com.getbase.floatingactionbutton.FloatingActionsMenu) bindings[3];
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
                setFragment((jp.yitt.bluetoothlowenergytest.MainFragment) variable);
                return true;
        }
        return false;
    }

    public void setFragment(jp.yitt.bluetoothlowenergytest.MainFragment fragment) {
        this.mFragment = fragment;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.fragment);
        super.requestRebind();
    }
    public jp.yitt.bluetoothlowenergytest.MainFragment getFragment() {
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
        jp.yitt.bluetoothlowenergytest.MainFragment fragment = mFragment;
        android.view.View.OnClickListener androidViewViewOnCli = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (fragment != null) {
                    // read fragment::startMeasurementActivity
                    androidViewViewOnCli = (((mAndroidViewViewOnCl == null) ? (mAndroidViewViewOnCl = new OnClickListenerImpl()) : mAndroidViewViewOnCl).setValue(fragment));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.actionLength.setOnClickListener(androidViewViewOnCli);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private jp.yitt.bluetoothlowenergytest.MainFragment value;
        public OnClickListenerImpl setValue(jp.yitt.bluetoothlowenergytest.MainFragment value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.startMeasurementActivity(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static FragmentMainBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentMainBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentMainBinding>inflate(inflater, jp.yitt.bluetoothlowenergytest.R.layout.fragment_main, root, attachToRoot, bindingComponent);
    }
    public static FragmentMainBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentMainBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(jp.yitt.bluetoothlowenergytest.R.layout.fragment_main, null, false), bindingComponent);
    }
    public static FragmentMainBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentMainBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_main_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentMainBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): fragment
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}