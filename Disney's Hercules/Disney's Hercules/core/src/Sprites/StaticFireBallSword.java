
package Sprites;

import MovingObjects.Hercules;
import com.Hercules.game.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class StaticFireBallSword extends Swords{
    int counter,soundcounter;
    public StaticFireBallSword(float x, float y, Hercules herucle) {
        this.herucle = herucle;this.x=x;this.y=y;
        manager=new AssetManager();
             manager.load("Audio/Hercules - Voices/Hercules/FireballSword.wav",Music.class);
             manager.finishLoading();
             music = manager.get("Audio/Hercules - Voices/Hercules/FireballSword.wav", Music.class);
             music.setLooping(false);
             music.setVolume(0.5f); 
        Tsword = new Texture("Sprites\\fireball1.png");
        Array<TextureRegion> frame= new Array<TextureRegion>();
        frame.add(new TextureRegion(Tsword,181,30,71,200));
        frame.add(new TextureRegion(Tsword,323,18,73,225));
        frame.add(new TextureRegion(Tsword,185,236,79,211));
        frame.add(new TextureRegion(Tsword,329,259,77,198));

        Asword = new Animation(0.1f, frame);
        Asword.setPlayMode(Animation.PlayMode.LOOP);
        frame.clear();
        counter=0;soundcounter=0;
        setBounds(0, 0, 79 / Main.PPM, 225 / Main.PPM);
        setPosition(x, y);
    }
     @Override
    public void update() {
       if (herucle.b2body.getPosition().x > x-(960/Main.PPM) && soundcounter==0)
        {
                  
             music.play();
             soundcounter++; 
        }
        if(herucle.b2body.getPosition().x >x&&herucle.b2body.getPosition().x <x+79/Main.PPM && herucle.b2body.getPosition().y>y&&herucle.b2body.getPosition().y<y+225/Main.PPM && counter==0)
        {
            counter++;
            herucle.pickedfireballsword=true;
            setBounds(0,0,0,0);
        }
        statetimer += Gdx.graphics.getDeltaTime();
        region = (TextureRegion) Asword.getKeyFrame(statetimer, true);
        setRegion(region);
        if (statetimer > 5) {
            statetimer = 0;
        }
    }
     public boolean Finish(){
        return false ;
    }
}

