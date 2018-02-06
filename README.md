# BannerViewPagerApp
Banner3d效果,公司UI需求，整理记录，参考
https://github.com/pinguo-zhouwei/MZBannerView
```
引用：
compile 'com.github.ZHBoy:BannerViewPagerApp:v1.0'
```
使用：
```
public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    //图片资源
    public static final int []RES_ARRAY = new int[]{R.drawable.icon_1,R.drawable.icon_2,R.drawable.icon_1,R.drawable.icon_2,R.drawable.icon_1,R.drawable.icon_2};
    private BannerViewPagerView bannerNormal;//正常
    private BannerViewPagerView bannerGalleryRadius;//圆角gallery
    private BannerViewPagerView bannerGalleryPadding;//间距gallery


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        bannerNormal = findViewById(R.id.banner_normal);
        bannerGalleryRadius = findViewById(R.id.banner_gallery_radius);
        bannerGalleryPadding = findViewById(R.id.banner_gallery_padding);

        bannerGalleryRadius.setBannerPageClickListener(new BannerViewPagerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Toast.makeText(MainActivity.this,"点击:"+position,Toast.LENGTH_LONG).show();
            }
        });
        bannerGalleryRadius.addPageChangeLisnter(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e(TAG,"----->addPageChangeLisnter:"+position + "positionOffset:"+positionOffset+ "positionOffsetPixels:"+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.e(TAG,"addPageChangeLisnter:"+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        List<Integer> bannerList = new ArrayList<>();
        for(int i=0;i<RES_ARRAY.length;i++){
            bannerList.add(RES_ARRAY[i]);
        }
        bannerGalleryRadius.setIndicatorVisible(true);

        bannerNormal.setPages(bannerList, new BannerHolderCreator<ViewHolder>() {
            @Override
            public ViewHolder createViewHolder() {
                return new ViewHolder();
            }
        });

        bannerGalleryRadius.setPages(bannerList, new BannerHolderCreator<ViewHolderRadius>() {
            @Override
            public ViewHolderRadius createViewHolder() {
                return new ViewHolderRadius();
            }
        });
        bannerGalleryPadding.setPages(bannerList, new BannerHolderCreator<ViewHolderPadding>() {
            @Override
            public ViewHolderPadding createViewHolder() {
                return new ViewHolderPadding();
            }
        });
    }

    //正常
    public static class ViewHolder implements BannerViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }

    /**
     * 圆角
     */
    public static class ViewHolderRadius implements BannerViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item_radius,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }

    //间距
    public static class ViewHolderPadding implements BannerViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item_padding,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        bannerNormal.pause();
        bannerGalleryPadding.pause();
        bannerGalleryRadius.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        bannerNormal.start();
        bannerGalleryPadding.start();
        bannerGalleryRadius.start();
    }
}
```



