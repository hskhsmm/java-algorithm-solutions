class Solution {
    public String solution(String new_id) {
        // 1~3단계: 소문자화, 특수문자 제거, 연속 마침표 치환
        String s = new_id.toLowerCase()
                .replaceAll("[^a-z0-9-_.]", "")
                .replaceAll("\\.{2,}", ".");

        // 4단계: 양 끝 마침표 제거
        s = s.replaceAll("^\\.|\\.$", "");

        // 5단계: 빈 문자열 처리
        if (s.isEmpty()) s = "a";

        // 6단계: 길이 제한 및 끝 마침표 제거
        if (s.length() >= 16) {
            s = s.substring(0, 15).replaceAll("\\.$", "");
        }

        // 7단계: 최소 길이 충족
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }
}