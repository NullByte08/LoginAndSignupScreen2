package com.example.loginandsignupscreen2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView logoImage;
    private TextInputLayout emailTextInput;
    private TextInputLayout passTextInput;
    private TextView forPassText;
    private Button loginButton;
    private TextView signupTextView;
    private ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        constraintLayout.setVisibility(View.GONE);
        startAnimation();


    }

    public void initializeViews(){
        constraintLayout=findViewById(R.id.afterAnimationConstraintLayout);
        logoImage=findViewById(R.id.logoImage);
        emailTextInput=findViewById(R.id.emailInputLayout);
        passTextInput=findViewById(R.id.passwordInputLayout);
        forPassText=findViewById(R.id.forPassTextView);
        loginButton=findViewById(R.id.loginButton);
        signupTextView=findViewById(R.id.signupTextView);
    }

    public void startAnimation(){
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(logoImage, "scaleX", 0.45f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(logoImage, "scaleY", 0.45f);
        scaleDownX.setDuration(1000);
        scaleDownY.setDuration(1000);

        ObjectAnimator moveUpY = ObjectAnimator.ofFloat(logoImage, "translationY", -400);
        moveUpY.setDuration(800);

        AnimatorSet scaleDown = new AnimatorSet();
        final AnimatorSet moveUp = new AnimatorSet();

        scaleDown.play(scaleDownX).with(scaleDownY);
        moveUp.play(moveUpY);

        scaleDown.start();
        new CountDownTimer(200,100){
            @Override
            public void onFinish() {
                moveUp.start();
            }
            @Override
            public void onTick(long l) {

            }
        }.start();
        scaleDown.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                constraintLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        /*ViewPropertyAnimator viewPropertyAnimator=logoImage.animate();
        float seventysix= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,76,this.getResources().getDisplayMetrics());
        float onefiftyfive= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,155,this.getResources().getDisplayMetrics());
        float hundred= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100,this.getResources().getDisplayMetrics());
        viewPropertyAnimator.translationY(76);
        viewPropertyAnimator.translationX(155);
        viewPropertyAnimator.setDuration(10000);
        viewPropertyAnimator.scaleX(100);
        viewPropertyAnimator.scaleY(-hundred);
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                constraintLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });*/

    }

}
