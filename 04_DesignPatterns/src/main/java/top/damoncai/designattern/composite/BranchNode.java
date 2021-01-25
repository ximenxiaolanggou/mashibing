package top.damoncai.designattern.composite;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/1/24 21:47
 */

@Data
@ToString
public class BranchNode extends Node {

    private List<Node> nodes = new ArrayList<>();
}
