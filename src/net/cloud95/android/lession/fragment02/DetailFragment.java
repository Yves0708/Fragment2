package net.cloud95.android.lession.fragment02;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//繼承自Support Library的Fragment類別
//從fragment_detail.xml轉成物件
public class DetailFragment extends Fragment {
    
    // 顯示標題和詳細內容用的畫面元件
    private TextView title_text, content_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // 載入指定的畫面配置資源
    	View result = inflater.inflate(R.layout.fragment_detail, container,false);
        // 讀取與設定畫面元件
    	content_text =(TextView) result.findViewById(R.id.content_text);
    	title_text = (TextView)result.findViewById(R.id.title_text);
    	return result;
    }
    
    // 更新畫面元件內容
    public void updateDetail(int position) {
    }

}