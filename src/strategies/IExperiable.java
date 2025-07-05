package strategies;

// that interface define the behaviour of exipration strategies
// we can add more in the future (any thing diifernt that canExpire we can add it saving us from changing in many places in the code)
// so
public interface IExperiable {
    boolean IsExpire();
}
