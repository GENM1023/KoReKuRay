package jp.yitt.bluetoothlowenergytest.databinding;
import jp.yitt.bluetoothlowenergytest.R;
import jp.yitt.bluetoothlowenergytest.BR;
import android.view.View;
public class ProductCardBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cardView, 1);
        sViewsWithIds.put(R.id.cardRelative, 2);
        sViewsWithIds.put(R.id.thumbnail, 3);
        sViewsWithIds.put(R.id.productName, 4);
        sViewsWithIds.put(R.id.dummy, 5);
        sViewsWithIds.put(R.id.price, 6);
        sViewsWithIds.put(R.id.corpName, 7);
    }
    // views
    public final android.widget.LinearLayout cardRelative;
    public final android.support.v7.widget.CardView cardView;
    public final android.widget.TextView corpName;
    public final android.widget.TextView dummy;
    private final android.widget.LinearLayout mboundView0;
    public final android.widget.TextView price;
    public final android.widget.TextView productName;
    public final android.widget.ImageView thumbnail;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ProductCardBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.cardRelative = (android.widget.LinearLayout) bindings[2];
        this.cardView = (android.support.v7.widget.CardView) bindings[1];
        this.corpName = (android.widget.TextView) bindings[7];
        this.dummy = (android.widget.TextView) bindings[5];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.price = (android.widget.TextView) bindings[6];
        this.productName = (android.widget.TextView) bindings[4];
        this.thumbnail = (android.widget.ImageView) bindings[3];
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
                return true;
        }
        return false;
    }

    public void setFragment(jp.yitt.bluetoothlowenergytest.SuggestFragment fragment) {
        // not used, ignore
    }
    public jp.yitt.bluetoothlowenergytest.SuggestFragment getFragment() {
        return null;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ProductCardBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ProductCardBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ProductCardBinding>inflate(inflater, jp.yitt.bluetoothlowenergytest.R.layout.product_card, root, attachToRoot, bindingComponent);
    }
    public static ProductCardBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ProductCardBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(jp.yitt.bluetoothlowenergytest.R.layout.product_card, null, false), bindingComponent);
    }
    public static ProductCardBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ProductCardBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/product_card_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ProductCardBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): fragment
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}