package org.bolin.daSanShang.dataSafety.work3;



import java.math.BigInteger;
import java.security.SecureRandom;

public class Paillier {
    private BigInteger p, q, n, nsquare, g, lambda, mu;
//    密钥长度
    private int bitLength;

    //  p,q的下限
    private BigInteger  lowBound ;

    // 构造函数，初始化密钥参数
    public Paillier(int bitLength) {
        this.bitLength = bitLength;
        lowBound = BigInteger.valueOf(2).pow(bitLength);
//        ConcurrentHashMap
    }

    // 1. 密钥生成
    public void keyGeneration(String studentIdReversed) {
        SecureRandom random = new SecureRandom();


        p=generatePrimeFromLastThree(studentIdReversed);


        q = BigInteger.probablePrime(bitLength, new SecureRandom()); // 随机生成大素数 q


        n = p.multiply(q); // n = p * q
        nsquare = n.multiply(n); // n^2
        g = new BigInteger(bitLength, random).mod(nsquare); // 选择 g

        lambda = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))
                .divide(p.subtract(BigInteger.ONE).gcd(q.subtract(BigInteger.ONE))); // 计算 λ
        mu = g.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).modInverse(n); // 计算 μ
    }

    // 2. 数据加密
    public BigInteger encrypt(BigInteger m) {
        SecureRandom random = new SecureRandom();
        BigInteger r = new BigInteger(bitLength, random).mod(n); // 生成随机数 r
        while (r.equals(BigInteger.ZERO)) {
            r = new BigInteger(bitLength, random).mod(n);
        }

        // c = g^m * r^n mod n^2
        return g.modPow(m, nsquare).multiply(r.modPow(n, nsquare)).mod(nsquare);
    }

    // 3. 数据解密
    public BigInteger decrypt(BigInteger c) {
        // u = c^λ mod n^2
        BigInteger u = c.modPow(lambda, nsquare);
        // L(u) = (u - 1) / n
        BigInteger l = u.subtract(BigInteger.ONE).divide(n);
        // m = L(u) * μ mod n
        return l.multiply(mu).mod(n);
    }

    // 4. 同态加法
    public BigInteger homomorphicAdd(BigInteger c1, BigInteger c2) {
        return c1.multiply(c2).mod(nsquare); // c_add = c1 * c2 mod n^2
    }


    // 获取学号后三位并倒序
    private static String getLastThreeReversed(String studentID) {
        String lastThree = studentID.substring(studentID.length() - 3);

        StringBuilder reversed = new StringBuilder(lastThree).reverse();
        if (reversed.charAt(0) == '0') {
            reversed.setCharAt(0, '1'); // 如果倒序后最后一位为 0，改为 1
        }
        return reversed.toString();
    }

    // 根据倒序后三位生成 p
    private BigInteger generatePrimeFromLastThree(String reversedLastThree) {

        // 添加足够的位数
        BigInteger cur=new BigInteger(reversedLastThree);


        while (cur.compareTo(lowBound)==-1){
//            注意要赋值啊
            cur=cur.multiply(BigInteger.valueOf(10));

        }

        while (!cur.isProbablePrime(20)){
//            注意要赋值啊
            cur= cur.add(BigInteger.valueOf(1));

        }
        return cur;
    }



    // 主方法，测试实验
    public static void main(String[] args) {
        // 学号后三位倒序（如最后一位是0，设置为1）
        String studentId = "32215300007";
        String lastThreeReversed = getLastThreeReversed(studentId);



        // 实例化 Paillier
        Paillier paillier = new Paillier(19); // 密钥长度19位
        paillier.keyGeneration(lastThreeReversed );

        // 明文数据
        BigInteger m1 = new BigInteger(lastThreeReversed); // 明文 m1
        BigInteger m2 = m1.add(BigInteger.valueOf(18)); // 明文 m2 = m1 + 18

        // 加密过程
//        BigInteger c1 = paillier.encrypt(m1);
//        BigInteger c2 = paillier.encrypt(m2);

        // 解密过程
//        BigInteger decryptedM1 = paillier.decrypt(c1);
//        BigInteger decryptedM2 = paillier.decrypt(c2);

        // 同态加法验证
//        BigInteger cAdd = paillier.homomorphicAdd(c1, c2); // c_add = c1 * c2 mod n^2
//        BigInteger decryptedAdd = paillier.decrypt(cAdd); // 解密 c_add
        long xx=1<<2;
        String s1= String.valueOf(xx);


        BigInteger a1 = new BigInteger("2");
        BigInteger a2 = new BigInteger("4");
        BigInteger a = a1.add(a2);

        BigInteger b1 = new BigInteger("3");
        BigInteger b2 = new BigInteger("4");
        BigInteger b = b1.add(b2);


        BigInteger r=new BigInteger("1");

        BigInteger d= paillier.encrypt(a1).pow(b2.intValue()).multiply(paillier.encrypt(b1).pow(a2.intValue())).multiply(paillier.encrypt(r));

        BigInteger decryptD = paillier.decrypt(d);
        BigInteger c1=a1.multiply(b1).add(decryptD);

        BigInteger c2=a2.multiply(b2).subtract(r);

        BigInteger c=c1.add(c2);
        BigInteger realC = a.multiply(b);
        if(c.equals(realC)){
            System.out.println("正确了呀");
        }



        BigInteger x1 = new BigInteger("6");
        BigInteger x2 = new BigInteger("10");
        BigInteger x = x1.add(x2);

        BigInteger y1 = new BigInteger("5");
        BigInteger y2 = new BigInteger("8");
        BigInteger y = y1.add(y2);



        BigInteger e = x.subtract(a);
        BigInteger e1 = x1.subtract(a1);
        BigInteger e2 = x2.subtract(a2);

        BigInteger f1 = y1.subtract(b1);
        BigInteger f2 = y2.subtract(b2);


        BigInteger f = y.subtract(b);
        BigInteger xy1 = e.multiply(f)
                .add(f.multiply(a1))
                .add(e.multiply(b1))
                .add(c1);
//        BigInteger xy1 = e.multiply(f).add(a.multiply(f1)).add(b.multiply(e1)).add(c1);

        BigInteger xy2 = f.multiply(a2).add(e.multiply(b2)).add(c2);
//        BigInteger xy2 = e.multiply(f).add(a.multiply(f2)).add(b.multiply(e2)).add(c2);

        BigInteger realXY = x.multiply(y);
        System.out.println(xy1);
        System.out.println(realXY);
        System.out.println(xy2);
        System.out.println("a1:"+a1+" a2:"+a2+" a:"+a+" b1:"+b1+ "  b2:"+b2+ " b:"+ b);
        System.out.println("e:" +e+" f:"+f+" c1: "+c1+" c2:"+ c2+" c:"+c);



        // 输出结果
        System.out.println("公钥为 p: " + paillier.p+"  g:" +paillier.g);
        System.out.println("私钥为 λ：" + paillier.lambda+"  μ"+paillier.mu);
        System.out.println("明文m1: " + m1 + ", 明文m2: " + m2);
        System.out.println("密文m1: " + c1);
//        System.out.println("密文 m2: " + c2);
//        System.out.println("解密后的m1: " + decryptedM1);
//        System.out.println("解密后的 m2: " + decryptedM2);

//        System.out.println("同台加法后解密的结果为: " + decryptedAdd);
    }
}

