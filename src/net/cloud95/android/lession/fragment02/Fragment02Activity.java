package net.cloud95.android.lession.fragment02;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

// 為了支援Support Library，所以繼承自FragmentActivity
// 實作MasterFragment.OnItemSelectedListener介面
public class Fragment02Activity extends FragmentActivity implements
		MasterFragment.OnItemSelectedListener {

	// 記錄目前選擇的項目編號
	private int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 會自動依照裝置直立或橫式狀態載入對應的畫面配置資源
		setContentView(R.layout.activity_fragment02);

		if (savedInstanceState != null) {// 如果不是第一次被使用
			// 如果裝置的方向是橫式
			if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
				// 為了支援Support Library，
				// 所以呼叫getSupportFragmentManager方法，
				// 取得FragmentManager物件
				FragmentManager manager = getSupportFragmentManager();
				// 讀取DetailFragment元件
				DetailFragment detail = (DetailFragment) manager
						.findFragmentById(R.id.detail_fragment);
				// 讀取儲存的項目編號
				position = savedInstanceState.getInt("position", 0);
				// 更新畫面內容
				detail.updateDetail(position);
			}
		}
	}

	// 把原來的資料載入
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// 儲存項目編號
		outState.putInt("position", position);
		super.onSaveInstanceState(outState);
	}

	// 讓Fragment元件呼叫的方法，接收使用者點擊的項目編號
	@Override
	public void onItemSelected(int position) {
		// 使用接收的參數設定項目編號
		this.position = position;
		// 如果裝置的方向是橫式
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			// 為了支援Support Library，
			// 所以呼叫getSupportFragmentManager方法，
			// 取得FragmentManager物件
			FragmentManager manager = getSupportFragmentManager();
			// 讀取DetailFragment元件
			DetailFragment detail = (DetailFragment) manager
					.findFragmentById(R.id.detail_fragment);
			// 更新畫面內容
			detail.updateDetail(position);
		}
		// 裝置的方向是直立
		else {
			// 準備啟動明細資料的Activity元件
			Intent intent = new Intent(this, DetailActivity.class);
			// 加入項目編號資料
			intent.putExtra("position", position);
			// 啟動Activity元件
			startActivity(intent);
		}
	}

}
