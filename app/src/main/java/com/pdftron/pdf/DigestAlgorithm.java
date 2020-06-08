//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import java.util.HashMap;

public enum DigestAlgorithm {
    e_sha1(0),
    e_sha256(1),
    e_sha384(2),
    e_sha512(3),
    e_ripemd160(4),
    e_unknown_digest_algorithm(5);

    private int a;
    private static HashMap<Integer, DigestAlgorithm> b = new HashMap();

    private DigestAlgorithm(int var3) {
        this.a = var3;
    }

    static DigestAlgorithm a(int var0) {
        return (DigestAlgorithm)b.get(var0);
    }

    static {
        DigestAlgorithm[] var0;
        int var1 = (var0 = values()).length;

        for(int var2 = 0; var2 < var1; ++var2) {
            DigestAlgorithm var3 = var0[var2];
            b.put(var3.a, var3);
        }

    }
}
