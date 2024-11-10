package com.raindown.codeview.link;

/**
 * date: 2024/4/30
 *
 * @author raindown
 */
public abstract class Minhandler {
    private Minhandler next;

    public Minhandler link(Minhandler first, Minhandler... chain) {
        Minhandler head = first;
        for (Minhandler nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    /**
     * Subclasses will implement this method with concrete checks.
     */
    public abstract boolean check(String email, String password);

    /**
     * ~
     * Runs check on the next object in chain or ends traversing if we're in
     * last object in chain.
     */
    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
