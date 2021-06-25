package ltcd_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTFromString_536 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode str2tree(String s) {

        int num = 0;
        int sign = 1;
        int index = 0;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = null;

        while (index < s.length()) {

            char c = s.charAt(index);

            if (c == '-') {
                sign = -1;
                index++;

            } else if (c >= '0' && c <= '9') {

                while (c >= '0' && c <= '9') {
                    num = num * 10 + Character.getNumericValue(c);
                    index++;
                    if (index < s.length()) {
                        c = s.charAt(index);
                    } else {
                        break;
                    }
                }
                num = num * sign;

                TreeNode newNode = new TreeNode(num);
                num = 0;
                sign = 1;

                if (stack.isEmpty()) {
                    root = newNode;
                    stack.push(newNode);
                } else {
                    TreeNode topNode = stack.peek();
                    if (topNode.left == null) topNode.left = newNode;
                    else topNode.right = newNode;
                    stack.push(newNode);
                }

            } else if (c == '(') {
                index++;
            } else if (c == ')') {
                index++;
                stack.pop();
            }
        }
        return root;
    }

    public String printTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        return printTreeHelper(list).toString();
    }

    public StringBuilder printTreeHelper(List<TreeNode> list) {

        if (list == null || list.size() <= 0) {
            return null;
        }

        List<TreeNode> leafList = new ArrayList<TreeNode>();
        StringBuilder thisLevel = new StringBuilder();

        for (TreeNode n: list) {
            thisLevel.append(n.val).append(",");
            if (n.left != null) leafList.add(n.left);
            if (n.right != null) leafList.add(n.right);
        }
        thisLevel.append(printTreeHelper(leafList));
        return thisLevel;
    }

    public static void main(String[] args) {
        BTFromString_536 object = new BTFromString_536();
        String input = "";
        String output = "";
        String expected = "";

        // example 1
        input = "4(2(3)(1))(6(5))";
        output = object.printTree(object.str2tree(input));
        expected = "4,2,6,3,1,5" + ",null";
        System.out.printf("Input: %s \nOutput: %s \nExpected: %s \nResult: %s\n\n", input, output, expected, (output.equals(expected)));

        // example 2
        input = "4(2(3)(1))(6(5)(7))";
        output = object.printTree(object.str2tree(input));
        expected = "4,2,6,3,1,5,7" + ",null";
        System.out.printf("Input: %s \nOutput: %s \nExpected: %s \nResult: %s\n\n",
                input, output, expected, (output.equals(expected)));

        // example 3
        input = "-4(2(3)(1))(6(5)(7))";
        output = object.printTree(object.str2tree(input));
        expected = "-4,2,6,3,1,5,7" + ",null";
        System.out.printf("Input: %s \nOutput: %s \nExpected: %s \nResult: %s\n\n",
                input, output, expected, (output.equals(expected)));

        //
        input = "-42(-21(-34)(-10))(-65(-53)(-72))";
        output = object.printTree(object.str2tree(input));
        expected = "-4,2,6,3,1,5,7" + ",null";
        System.out.printf("Input: %s \nOutput: %s \nExpected: %s \nResult: %s\n\n",
                input, output, expected, (output.equals(expected)));

        // after submit test 1
        input = "4";
        output = object.printTree(object.str2tree(input));
        expected = "4" + ",null";
        System.out.printf("Input: %s \nOutput: %s \nExpected: %s \nResult: %s\n\n",
                input, output, expected, (output.equals(expected)));

        // after submit test 2
        /*input = "-359(-418(-543(419(-48(931(-244(-398(-413(-142(-510(-289(-855(-250(545)(-967))))))(-790(354(-226(-872(216(-15)(-329))(856(83)(-234)))(912(769(657)(719))(104(357)(-968)))))))(-390(270(-171(-340(-16(678(780)))(329(-248(237))(-245(-220)(-229)))))(290(-115(-266(-349(904))(-123(384)(302))))))(-819(-333(-288(750(-194(988)))))))))(-520(-873(-895(952(617(807(193(358(-899)(-287)))(77(285(-990))))(-407(545(388(-958)(472))(493(928)))(-534(-13(-976)(-2))))))(488(-374(520(406(-710(986)))(256(-747(6))))(-390(-647(314(-480)(323))(-862(947)(-379)))))(384(871(951(684(-979))(-687(-299)(714))))(557(-488(-335(358)))(-903(-546(406))(-392(690)(-464)))))))(412(614(398(-727(173(-751(-141))))(525(623(-891(-523)))(101(-587(575)(-944))(240(771))))))(802(-444(-63(-38(-231(242)(-274))(-584(26)(-45)))(829(285(-22))))(748(496(-805(423))(593(605)(-942))))))))))(146(538(-944(-455(69(-480(320(155(699(-48)(-71))(799(23)(-191)))(-877(884(-845))(739(-659)(13))))(121(-282(426(971)(544))(959(-937)))))(207(323(-248(812(816)(265))))(607(-488(-132(174)(-795))(779(12)))(-704(-240(241))(-101(-132)))))))))))))(850(-402(-568(-308(290(-404(873(-252(-900(-759(126(-226(923)(119))(-547(-224)(-759)))(-102(-69(444))(-86(37)(-747))))))))(88(248(816(-956(-315(-385(380(-724)(458)))(595(-7(-76))))(-786(445(-286(654)))(371(-863(155)(-922))(757(-283))))))(363(-304(-874(593(-649(632))))(-437(739(21(-961)(106))(-457(-452)(-105)))))(341(605(-266(-641(124)))(133(-648(-497))(-220(259)(609))))(6(-691(611(862)(-263)))))))(-806(-960(-825(760(-137(-83(-22)(-559))(-736(310)(-837))))(-827(-84(-921(-155)(140)))))(-710(552(843(-572(91)(-957))))(-93(-188(444(282)(-458)))(413(-181(513)(671))))))))))(-716(430(162(950(-188(406(-289(-233(669(-929)(377))))))(756(629(253(-344(-402(-807)(-718))(299(395)(602)))(-803(-5(-973)(978))(-700(70))))(-537(-146(887(999)))(-860(456(703))(-496(-279)))))(201(-154(918(-643(18)(-188)))))))(-871(593(655(-406(-746(145(-908))(-10(559)))(-939(-323(-305)(-642))(-694(-988)))))(-171(-357(-5(672(522))(969(213)(239)))(603(-143(-187))))(752(400(-514(60)(34))))))(86(-123(-727(-737(-978(-298)(-519))(163(123)(-344)))(-816(323(-998))(503(304)(404))))(-553(633(-334(-190))(-597(868)))(-433(53(312)(783)))))(-301(-196(-535(988(640))))(-578(647(-28(-951)(85))(-727(759)))(563(-361(-91)))))))))(467(309(-91(225(875(-378(259(-949(865))(-295(-767)(550))))(-133(-347(-966(677)(133))(558(501)(615)))(-409(538(-929))(560(-559)(-894))))))(-342(-782(840(-393(-983(-329)))))(-613(19(-160(-670(521)(89))(738(-22)(650)))(-301(84(-932))))))))(-111(425(-109(397(-470(-801(-292(896))(375(-586))))(-353(860(259(-572)(-809)))(958(-217(904)(410)))))(405(946(-493(476(154)(-935))))))))))))(702(-129(686(748(-591(31(338(-16(80(-307(-889(456))(631(102)))))(359(855(708(-127(813)))(-528(333(-218)(-622))))(275(462(806(850)(-792))(213(202)(-539))))))(-533(-483(330(499(170(224))(-26(837)(170)))(87(200(-254)(-511))(-988(69)(-159))))(142(396(97(624)(-118)))(-779(-27(794)))))(568(59(502(550(699)(-253))(495(-94))))))))(-290(-702(-508(435(749(139(354(-327))(-983(691))))(951(406(137(-19))))))(319(-417(651(-999(-609(-64)(-395)))(931(-404(779)(677))(245(-76)(-112)))))(-247(40(256(749(-614)))))))))(540(154(-211(525(502(758(-888(588(346)(16))(-492(-200)))(-989(992(518)(836))))))))))(903(-191(920(-513(-511(157(706(297(-7(-622)(942)))(-179(678(-790))(652(734))))(-617(822(369(-971)(-894))(906(-478)(692)))(-149(-582(657))(-863(-655)(-121))))))(326(-96(-497(275(177(736)(832)))(886(178(-150))))(40(-163(627(13)(-158)))(-411(733(-975)))))(694(150(601(-857(942))(-722(-895)(603)))(-307(-595(497)(-863))(-441(-883)(-553)))))))(16(-161(-377(755(276(-939(211)(892))(-958(589)(-840))))(-676(104(-393(465))(-279(-925)))(653(-595(-535)(927))(-576(-594)(-599))))))))(-672(430(-800(-473(-139(-370(-279(994)(19))(-371(-455)))))))))(665(-248(29(429(-934(-452(-652(-826(80)(-618)))(35(886(-398))))(-641(-497(-808(-436)))(-723(583(-516)(-42))(634(292)))))))(250(-456(106(-910(-546(503(-546))(-532(-213)))(-920(830(856)(-16)))))(-61(-788(998(159(-291)(-962))))))))))))))";
        output = object.printTree(object.str2tree(input));
        expected = "4" + ",null";
        System.out.printf("Input: %s \nOutput: %s \nExpected: %s \nResult: %s\n\n",
                input, output, expected, (output.equals(expected)));*/


    }
}
