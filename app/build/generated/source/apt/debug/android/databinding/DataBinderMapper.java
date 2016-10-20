
package android.databinding;
import jp.yitt.bluetoothlowenergytest.BR;
class DataBinderMapper {
    final static int TARGET_MIN_SDK = 18;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case jp.yitt.bluetoothlowenergytest.R.layout.list_item_object:
                    return jp.yitt.bluetoothlowenergytest.databinding.ListItemObjectBinding.bind(view, bindingComponent);
                case jp.yitt.bluetoothlowenergytest.R.layout.product_card:
                    return jp.yitt.bluetoothlowenergytest.databinding.ProductCardBinding.bind(view, bindingComponent);
                case jp.yitt.bluetoothlowenergytest.R.layout.fragment_main:
                    return jp.yitt.bluetoothlowenergytest.databinding.FragmentMainBinding.bind(view, bindingComponent);
                case jp.yitt.bluetoothlowenergytest.R.layout.list_item_length:
                    return jp.yitt.bluetoothlowenergytest.databinding.ListItemLengthBinding.bind(view, bindingComponent);
                case jp.yitt.bluetoothlowenergytest.R.layout.fragment_suggest:
                    return jp.yitt.bluetoothlowenergytest.databinding.FragmentSuggestBinding.bind(view, bindingComponent);
                case jp.yitt.bluetoothlowenergytest.R.layout.fragment_measurement:
                    return jp.yitt.bluetoothlowenergytest.databinding.FragmentMeasurementBinding.bind(view, bindingComponent);
                case jp.yitt.bluetoothlowenergytest.R.layout.list_item_area:
                    return jp.yitt.bluetoothlowenergytest.databinding.ListItemAreaBinding.bind(view, bindingComponent);
                case jp.yitt.bluetoothlowenergytest.R.layout.dialog_data_saving:
                    return jp.yitt.bluetoothlowenergytest.databinding.DialogDataSavingBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 485011456: {
                if(tag.equals("layout/list_item_object_0")) {
                    return jp.yitt.bluetoothlowenergytest.R.layout.list_item_object;
                }
                break;
            }
            case -44030570: {
                if(tag.equals("layout/product_card_0")) {
                    return jp.yitt.bluetoothlowenergytest.R.layout.product_card;
                }
                break;
            }
            case -985887980: {
                if(tag.equals("layout/fragment_main_0")) {
                    return jp.yitt.bluetoothlowenergytest.R.layout.fragment_main;
                }
                break;
            }
            case -1964049945: {
                if(tag.equals("layout/list_item_length_0")) {
                    return jp.yitt.bluetoothlowenergytest.R.layout.list_item_length;
                }
                break;
            }
            case -1033558517: {
                if(tag.equals("layout/fragment_suggest_0")) {
                    return jp.yitt.bluetoothlowenergytest.R.layout.fragment_suggest;
                }
                break;
            }
            case -506427069: {
                if(tag.equals("layout/fragment_measurement_0")) {
                    return jp.yitt.bluetoothlowenergytest.R.layout.fragment_measurement;
                }
                break;
            }
            case -1123109426: {
                if(tag.equals("layout/list_item_area_0")) {
                    return jp.yitt.bluetoothlowenergytest.R.layout.list_item_area;
                }
                break;
            }
            case -1789431762: {
                if(tag.equals("layout/dialog_data_saving_0")) {
                    return jp.yitt.bluetoothlowenergytest.R.layout.dialog_data_saving;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"fragment"
            ,"model"};
    }
}