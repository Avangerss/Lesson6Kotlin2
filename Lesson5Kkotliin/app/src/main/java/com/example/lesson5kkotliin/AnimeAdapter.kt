package com.example.lesson5kkotliin

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var anime = listOf<Manga>()

    fun setData(data: List<Manga>){
        anime = data
    }
    class AnimeViewHolder(private val binding: ItemAnimeBinding) : ViewHolder(binding.root) {

        fun onBind(manga: Manga) = with(binding) {
            animeCover.setImageResource(manga.image)
            animeTv.text = manga.title
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AnimeViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeAdapter.AnimeViewHolder, position: Int) {
        holder.onBind(anime[position])
    }

    override fun getItemCount(): Int = anime.size
}