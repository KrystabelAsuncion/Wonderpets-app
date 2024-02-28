import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CartSharedViewModel : ViewModel() {
    val cartItemsLiveData = MutableLiveData<List<CartItem>>()
}
