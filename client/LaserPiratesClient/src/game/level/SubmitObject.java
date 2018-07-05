package game.level;

import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;

/**
 *
 * @author Marco
 */
public class SubmitObject<T> {
    private T submitObject;

    public SubmitObject(T function) {
        this.submitObject = function;
    }

    public T getSubmit() {
        return submitObject;
    }
}
