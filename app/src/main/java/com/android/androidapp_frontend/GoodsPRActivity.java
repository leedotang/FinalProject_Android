package com.android.androidapp_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.androidapp_frontend.retrofit.MemberVO;

public class GoodsPRActivity extends AppCompatActivity {

    Button btnGoMain, btnHome;

    VideoView videoView;
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_pr);

        btnGoMain = (Button) findViewById(R.id.btnGoMain);
        btnHome = (Button) findViewById(R.id.btnHome);

        btnGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LogInSuccess.class);
                startActivity(intent);
            }
        });

        // activity_goods_pr.xml 레이아웃의 videoView를 연계 처리 형식을
        // videoView 변수에 담아줍니다.
        videoView = (VideoView) this.findViewById(R.id.videoView);
        btnStart = (Button) this.findViewById(R.id.btnStart);
        btnStop = (Button) this.findViewById(R.id.btnStop);

        //미디어컨트롤러를 추가해 줍니다.
        MediaController controller = new MediaController(GoodsPRActivity.this);
        videoView.setMediaController(controller);

        //비디오뷰 포커스를 요청합니다.
        videoView.requestFocus();

        MediaController mc = new MediaController(this);
        //비디오뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤바(MediaController)'를 셋팅해 줍니다.
        videoView.setMediaController(mc);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.trailer));

        videoView.start();

        // "(중요) 자동 실행 희망할 경우,  아래 1줄 videoView.start(); 구문 추가" 바랍니다.
        // 그리고, 아래 "자동 시작 방지 : StartButton 클릭 시 동영상 재생됨" 밑에 1줄 소스를 삭제(또는 주석 처리) 바랍니다
//        videoView.start();


        //동영상 재생이 완료된 걸 알 수 있는 리스너
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //동영상 재생이 완료된 후 호출되는 메소드
                Toast.makeText(GoodsPRActivity.this,
                        "동영상 재생이 완료되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }
    //시작 버튼 onClick Method
    public void StartButton(View v) {
        // 자동 시작 방지 : StartButton 클릭 시 동영상 재생됨
        // 자동 시작을 희망할 경우, 아래 1줄 videoView.start(); 구문을 삭제(또는 주석 처리)하고,
        // 위에 "(중요) 자동 실행 희망할 경우,  아래 1줄 videoView.start(); 구문 추가 바랍니다.
//        videoView.start();
        playVideo();
    }

    //정지 버튼 onClick Method
    public void StopButton(View v) {
        stopVideo();
    }

    //동영상 재생 Method
    private void playVideo() {
        videoView.start();
    }

    //동영상 정지 Method
    private void stopVideo() {
        //비디오 재생 멈춤
        videoView.pause();
    }
}