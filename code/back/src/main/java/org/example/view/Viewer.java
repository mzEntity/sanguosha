package org.example.view;

import org.example.game.logic.Action;
import org.example.game.logic.action.card.DiscardAction;
import org.example.game.logic.action.card.GetCardFromDrawAreaAction;
import org.example.game.logic.action.divination.SDS01WorkAction;
import org.example.game.logic.action.divination.SDS02WorkAction;
import org.example.game.logic.action.global.GameOverAction;
import org.example.game.logic.action.play.PlaySB01Action;
import org.example.game.logic.action.play.PlaySB02Action;
import org.example.game.logic.action.role.*;
import org.example.game.logic.action.use.*;
import org.example.game.logic.action.use.delayed.UseSDS01Action;
import org.example.game.logic.action.use.delayed.UseSDS02Action;
import org.example.game.logic.action.use.undelayed.*;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/25
 */
public abstract class Viewer {
    public void display(Action action){
        if(action instanceof DiscardAction){
            this.display((DiscardAction) action);
        } else if(action instanceof GetCardFromDrawAreaAction){
            this.display((GetCardFromDrawAreaAction) action);
        } else if(action instanceof SDS01WorkAction){
            this.display((SDS01WorkAction) action);
        } else if(action instanceof SDS02WorkAction){
            this.display((SDS02WorkAction) action);
        } else if(action instanceof GameOverAction){
            this.display((GameOverAction) action);
        } else if(action instanceof PlaySB01Action){
            this.display((PlaySB01Action) action);
        } else if(action instanceof PlaySB02Action){
            this.display((PlaySB02Action) action);
        } else if(action instanceof DiscardFromPlayerAreaAction){
            this.display((DiscardFromPlayerAreaAction) action);
        } else if(action instanceof GainHealthAction){
            this.display((GainHealthAction) action);
        } else if(action instanceof GetCardFromPlayerAreaAction){
            this.display((GetCardFromPlayerAreaAction) action);
        } else if(action instanceof InjurySettleAction){
            this.display((InjurySettleAction) action);
        } else if(action instanceof UseSUS01Action){
            this.display((UseSUS01Action) action);
        } else if(action instanceof UseSUS02Action){
            this.display((UseSUS02Action) action);
        } else if(action instanceof UseSUS03Action){
            this.display((UseSUS03Action) action);
        } else if(action instanceof UseSUS04Action){
            this.display((UseSUS04Action) action);
        } else if(action instanceof UseSUS05Action){
            this.display((UseSUS05Action) action);
        } else if(action instanceof UseSUS06Action){
            this.display((UseSUS06Action) action);
        } else if(action instanceof UseSUS07Action){
            this.display((UseSUS07Action) action);
        } else if(action instanceof UseSUS08Action){
            this.display((UseSUS08Action) action);
        } else if(action instanceof UseSUS09Action){
            this.display((UseSUS09Action) action);
        } else if(action instanceof UseSUS10Action){
            this.display((UseSUS10Action) action);
        } else if(action instanceof UseSDS01Action){
            this.display((UseSDS01Action)action);
        } else if(action instanceof UseSDS02Action){
            this.display((UseSDS02Action) action);
        } else if(action instanceof UseWeaponAction){
            this.display((UseWeaponAction) action);
        } else if(action instanceof UseArmorAction){
            this.display((UseArmorAction) action);
        } else if(action instanceof UseMountAction){
            this.display((UseMountAction) action);
        } else if(action instanceof UseSB01Action) {
            this.display((UseSB01Action) action);
        } else if(action instanceof UseSB02Action){
            this.display((UseSB02Action) action);
        } else if(action instanceof UseSB03Action){
            this.display((UseSB03Action) action);
        } else if(action instanceof DeadAction){
            this.display((DeadAction)action);
        }
    }

    public void display(DiscardAction discardAction){}

    public void display(GetCardFromDrawAreaAction getCardFromDrawAreaAction){}

    public void display(SDS01WorkAction sds01WorkAction){}

    public void display(SDS02WorkAction sds02WorkAction){}

    public void display(GameOverAction gameOverAction){}

    public void display(PlaySB01Action playSB01Action){}

    public void display(PlaySB02Action playSB02Action){}

    public void display(DiscardFromPlayerAreaAction discardFromPlayerAreaAction){}

    public void display(GainHealthAction gainHealthAction){}

    public void display(GetCardFromPlayerAreaAction getCardFromPlayerAreaAction){}

    public void display(InjurySettleAction injurySettleAction){}

    public void display(UseSB01Action useSB01Action){}

    public void display(UseSB02Action useSB02Action){}

    public void display(UseSB03Action useSB03Action){}

    public void display(UseSUS01Action useSUS01Action){}

    public void display(UseSUS02Action useSUS02Action){}

    public void display(UseSUS03Action useSUS03Action){}

    public void display(UseSUS04Action useSUS04Action){}

    public void display(UseSUS05Action useSUS05Action){}

    public void display(UseSUS06Action useSUS06Action){}

    public void display(UseSUS07Action useSUS07Action){}

    public void display(UseSUS08Action useSUS08Action){}

    public void display(UseSUS09Action useSUS09Action){}

    public void display(UseSUS10Action useSUS10Action){}

    public void display(UseSDS01Action sds01Action){}

    public void display(UseSDS02Action sds02Action){}

    public void display(UseWeaponAction useWeaponAction){}

    public void display(UseArmorAction useArmorAction){}

    public void display(UseMountAction useMountAction){}

    public void display(DeadAction deadAction){}
}
