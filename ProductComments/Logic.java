import java.util.*;

public final class Logic {
    private Logic() {}

    public static String calcData(Integer partId, Part[] assembly, Comment[] comments) {
        Map<Integer, Integer> partsMap = new HashMap<>();
        for (Part part : assembly) {
            partsMap.put(part.getPartId(), part.getParentPartId());
        }
        Map<Integer, String> commentsMap = new HashMap<>();
        for (Comment comment : comments) {
            commentsMap.put(comment.getPartId(), comment.getComment());
        }

        int mainPartId = getMainPartId(partId, partsMap);
        List<Integer> relatedPartIds = getRelatedPartIds(mainPartId, partsMap);

        return buildOutput(partId, mainPartId, relatedPartIds, commentsMap);
    }

    private static int getMainPartId(int partId, Map<Integer, Integer> partsMap) {
        if (partsMap.get(partId) != 0) {
            return getMainPartId(partsMap.get(partId), partsMap);
        }
        return partId;
    }

    private static List<Integer> getRelatedPartIds(int mainPartId, Map<Integer, Integer> partsMap) {
        List<Integer> relatedPartIds = new ArrayList<>(List.of(mainPartId));
        List<Integer> childrenIds = Collections.singletonList(mainPartId);
        while (!childrenIds.isEmpty()) {
            for (int partId : childrenIds) {
                childrenIds = getChildrenIds(partId, partsMap);
                relatedPartIds.addAll(childrenIds);
            }
        }
        return relatedPartIds;
    }

    private static List<Integer> getChildrenIds(int partId, Map<Integer, Integer> partsMap) {
        List<Integer> childrenIds = new ArrayList<>();
        for (Map.Entry<Integer, Integer> part : partsMap.entrySet()) {
            if (part.getValue() == partId) {
                childrenIds.add(part.getKey());
            }
        }
        return childrenIds;
    }

    private static String buildOutput(int partId, int mainPartId, List<Integer> relatedPartIds, Map<Integer, String> commentsMap) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Input: %s\n", partId)).append("Output:\n")
                .append(String.format("Main Part: %s\n", mainPartId)).append("Comments:\n");
        for (int id : relatedPartIds) {
            sb.append(String.format("%s\n", commentsMap.get(id)));
        }
        return sb.toString();
    }

}
