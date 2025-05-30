package PR.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PR_베스트엘범_HashMap {

    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            // 1. 장르별 총 재생 횟수와 노래 정보 저장
            Map<String, Integer> genrePlayCount = new HashMap<>();
            Map<String, List<int[]>> genreToSongs = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                String genre = genres[i];
                int play = plays[i];
                int index = i;

                // 1) 총 재생 횟수 계산
                genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

                // 2) 장르별 노래 추가
                genreToSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(new int[]{index, play});
            }

            List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
            sortedGenres.sort((o1, o2) -> genrePlayCount.get(o2) - genrePlayCount.get(o1));

            List<Integer> bestAlbum = new ArrayList<>();

            for (String genre : sortedGenres) {
                genreToSongs.get(genre).sort((s1, s2) -> s1[1] == s2[1] ? s1[0] - s2[0] : s2[1] - s1[1]);

                for(int i = 0; i <Math.min(2, genreToSongs.get(genre).size()); i++){
                    bestAlbum.add(genreToSongs.get(genre).get(i)[0]);
                }
            }
            return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
