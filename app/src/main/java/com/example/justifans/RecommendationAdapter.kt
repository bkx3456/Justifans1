import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justifans.R

// Model data untuk item
data class Recommendation(
    val productName: String,
    val productPrice: String,
    val productImageResId: Int // Resource ID untuk gambar
)

// Adapter untuk RecyclerView
class RecommendationAdapter(private val items: List<Recommendation>) :
    RecyclerView.Adapter<RecommendationAdapter.item_recommendation>() {

    // ViewHolder untuk item layout
    class item_recommendation (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.ivProductImage)
        val productName: TextView = itemView.findViewById(R.id.tvProductTitle)
        val productPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
    }

    // Inflate layout item_recommendation untuk setiap item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): item_recommendation {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recommendation, parent, false)
        return item_recommendation(view)
    }

    // Bind data ke tampilan di ViewHolder
    override fun onBindViewHolder(holder: item_recommendation, position: Int) {
        val item = items[position]
        holder.productName.text = item.productName
        holder.productPrice.text = item.productPrice
        holder.productImage.setImageResource(item.productImageResId) // Set gambar produk
    }

    // Jumlah item di RecyclerView
    override fun getItemCount(): Int = items.size
}
