package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public final class BuiltinOperator {
    public static final int ABS = 101;
    public static final int ADD = 0;
    public static final int ADD_N = 106;
    public static final int ARG_MAX = 56;
    public static final int ARG_MIN = 79;
    public static final int ASSIGN_VARIABLE = 144;
    public static final int ATAN2 = 156;
    public static final int AVERAGE_POOL_2D = 1;
    public static final int BATCH_MATMUL = 126;
    public static final int BATCH_TO_SPACE_ND = 37;
    public static final int BIDIRECTIONAL_SEQUENCE_LSTM = 52;
    public static final int BIDIRECTIONAL_SEQUENCE_RNN = 46;
    public static final int BROADCAST_ARGS = 145;
    public static final int BROADCAST_TO = 130;
    public static final int BUCKETIZE = 147;
    public static final int CALL = 31;
    public static final int CALL_ONCE = 129;
    public static final int CAST = 53;
    public static final int CEIL = 104;
    public static final int COMPLEX_ABS = 135;
    public static final int CONCATENATION = 2;
    public static final int CONCAT_EMBEDDINGS = 29;
    public static final int CONV_2D = 3;
    public static final int CONV_3D = 132;
    public static final int CONV_3D_TRANSPOSE = 141;
    public static final int COS = 108;
    public static final int CUMSUM = 128;
    public static final int CUSTOM = 32;
    public static final int DELEGATE = 51;
    public static final int DENSIFY = 124;
    public static final int DEPTHWISE_CONV_2D = 4;
    public static final int DEPTH_TO_SPACE = 5;
    public static final int DEQUANTIZE = 6;
    public static final int DIV = 42;
    public static final int DYNAMIC_UPDATE_SLICE = 151;
    public static final int ELU = 111;
    public static final int EMBEDDING_LOOKUP = 7;
    public static final int EMBEDDING_LOOKUP_SPARSE = 33;
    public static final int EQUAL = 71;
    public static final int EXP = 47;
    public static final int EXPAND_DIMS = 70;
    public static final int FAKE_QUANT = 80;
    public static final int FILL = 94;
    public static final int FLOOR = 8;
    public static final int FLOOR_DIV = 90;
    public static final int FLOOR_MOD = 95;
    public static final int FULLY_CONNECTED = 9;
    public static final int GATHER = 36;
    public static final int GATHER_ND = 107;
    public static final int GELU = 150;
    public static final int GREATER = 61;
    public static final int GREATER_EQUAL = 62;
    public static final int HARD_SWISH = 117;
    public static final int HASHTABLE = 136;
    public static final int HASHTABLE_FIND = 137;
    public static final int HASHTABLE_IMPORT = 138;
    public static final int HASHTABLE_LOOKUP = 10;
    public static final int HASHTABLE_SIZE = 139;
    public static final int IF = 118;
    public static final int IMAG = 133;
    public static final int L2_NORMALIZATION = 11;
    public static final int L2_POOL_2D = 12;
    public static final int LEAKY_RELU = 98;
    public static final int LESS = 58;
    public static final int LESS_EQUAL = 63;
    public static final int LOCAL_RESPONSE_NORMALIZATION = 13;
    public static final int LOG = 73;
    public static final int LOGICAL_AND = 86;
    public static final int LOGICAL_NOT = 87;
    public static final int LOGICAL_OR = 84;
    public static final int LOGISTIC = 14;
    public static final int LOG_SOFTMAX = 50;
    public static final int LSH_PROJECTION = 15;
    public static final int LSTM = 16;
    public static final int MATRIX_DIAG = 113;
    public static final int MATRIX_SET_DIAG = 115;
    public static final int MAXIMUM = 55;
    public static final int MAX_POOL_2D = 17;
    public static final int MEAN = 40;
    public static final int MINIMUM = 57;
    public static final int MIRROR_PAD = 100;
    public static final int MUL = 18;
    public static final int MULTINOMIAL = 149;
    public static final int NEG = 59;
    public static final int NON_MAX_SUPPRESSION_V4 = 120;
    public static final int NON_MAX_SUPPRESSION_V5 = 121;
    public static final int NOT_EQUAL = 72;
    public static final int ONE_HOT = 85;
    public static final int PACK = 83;
    public static final int PAD = 34;
    public static final int PADV2 = 60;
    public static final int PLACEHOLDER_FOR_GREATER_OP_CODES = 127;
    public static final int POW = 78;
    public static final int PRELU = 54;
    public static final int QUANTIZE = 114;
    public static final int RANDOM_STANDARD_NORMAL = 146;
    public static final int RANDOM_UNIFORM = 148;
    public static final int RANGE = 96;
    public static final int RANK = 110;
    public static final int READ_VARIABLE = 143;
    public static final int REAL = 134;
    public static final int REDUCE_ALL = 140;
    public static final int REDUCE_ANY = 91;
    public static final int REDUCE_MAX = 82;
    public static final int REDUCE_MIN = 89;
    public static final int REDUCE_PROD = 81;
    public static final int RELU = 19;
    public static final int RELU6 = 21;
    public static final int RELU_0_TO_1 = 152;
    public static final int RELU_N1_TO_1 = 20;
    public static final int RESHAPE = 22;
    public static final int RESIZE_BILINEAR = 23;
    public static final int RESIZE_NEAREST_NEIGHBOR = 97;
    public static final int REVERSE_SEQUENCE = 112;
    public static final int REVERSE_V2 = 105;
    public static final int RFFT2D = 131;
    public static final int RNN = 24;
    public static final int ROUND = 116;
    public static final int RSQRT = 76;
    public static final int SCATTER_ND = 122;
    public static final int SEGMENT_SUM = 125;
    public static final int SELECT = 64;
    public static final int SELECT_V2 = 123;
    public static final int SHAPE = 77;
    public static final int SIGN = 158;
    public static final int SIN = 66;
    public static final int SKIP_GRAM = 30;
    public static final int SLICE = 65;
    public static final int SOFTMAX = 25;
    public static final int SPACE_TO_BATCH_ND = 38;
    public static final int SPACE_TO_DEPTH = 26;
    public static final int SPARSE_TO_DENSE = 68;
    public static final int SPLIT = 49;
    public static final int SPLIT_V = 102;
    public static final int SQRT = 75;
    public static final int SQUARE = 92;
    public static final int SQUARED_DIFFERENCE = 99;
    public static final int SQUEEZE = 43;
    public static final int STRIDED_SLICE = 45;
    public static final int SUB = 41;
    public static final int SUM = 74;
    public static final int SVDF = 27;
    public static final int TANH = 28;
    public static final int TILE = 69;
    public static final int TOPK_V2 = 48;
    public static final int TRANSPOSE = 39;
    public static final int TRANSPOSE_CONV = 67;
    public static final int UNIDIRECTIONAL_SEQUENCE_LSTM = 44;
    public static final int UNIDIRECTIONAL_SEQUENCE_RNN = 35;
    public static final int UNIQUE = 103;
    public static final int UNPACK = 88;
    public static final int UNSORTED_SEGMENT_MAX = 154;
    public static final int UNSORTED_SEGMENT_MIN = 157;
    public static final int UNSORTED_SEGMENT_PROD = 153;
    public static final int UNSORTED_SEGMENT_SUM = 155;
    public static final int VAR_HANDLE = 142;
    public static final int WHERE = 109;
    public static final int WHILE = 119;
    public static final int ZEROS_LIKE = 93;
    public static final String[] names = {"ADD", "AVERAGE_POOL_2D", "CONCATENATION", "CONV_2D", "DEPTHWISE_CONV_2D", "DEPTH_TO_SPACE", "DEQUANTIZE", "EMBEDDING_LOOKUP", "FLOOR", "FULLY_CONNECTED", "HASHTABLE_LOOKUP", "L2_NORMALIZATION", "L2_POOL_2D", "LOCAL_RESPONSE_NORMALIZATION", "LOGISTIC", "LSH_PROJECTION", "LSTM", "MAX_POOL_2D", "MUL", "RELU", "RELU_N1_TO_1", "RELU6", "RESHAPE", "RESIZE_BILINEAR", "RNN", "SOFTMAX", "SPACE_TO_DEPTH", "SVDF", "TANH", "CONCAT_EMBEDDINGS", "SKIP_GRAM", "CALL", "CUSTOM", "EMBEDDING_LOOKUP_SPARSE", "PAD", "UNIDIRECTIONAL_SEQUENCE_RNN", "GATHER", "BATCH_TO_SPACE_ND", "SPACE_TO_BATCH_ND", "TRANSPOSE", "MEAN", "SUB", "DIV", "SQUEEZE", "UNIDIRECTIONAL_SEQUENCE_LSTM", "STRIDED_SLICE", "BIDIRECTIONAL_SEQUENCE_RNN", "EXP", "TOPK_V2", "SPLIT", "LOG_SOFTMAX", "DELEGATE", "BIDIRECTIONAL_SEQUENCE_LSTM", "CAST", "PRELU", "MAXIMUM", "ARG_MAX", "MINIMUM", "LESS", "NEG", "PADV2", "GREATER", "GREATER_EQUAL", "LESS_EQUAL", "SELECT", "SLICE", "SIN", "TRANSPOSE_CONV", "SPARSE_TO_DENSE", "TILE", "EXPAND_DIMS", "EQUAL", "NOT_EQUAL", "LOG", "SUM", "SQRT", "RSQRT", "SHAPE", "POW", "ARG_MIN", "FAKE_QUANT", "REDUCE_PROD", "REDUCE_MAX", "PACK", "LOGICAL_OR", "ONE_HOT", "LOGICAL_AND", "LOGICAL_NOT", "UNPACK", "REDUCE_MIN", "FLOOR_DIV", "REDUCE_ANY", "SQUARE", "ZEROS_LIKE", "FILL", "FLOOR_MOD", "RANGE", "RESIZE_NEAREST_NEIGHBOR", "LEAKY_RELU", "SQUARED_DIFFERENCE", "MIRROR_PAD", "ABS", "SPLIT_V", "UNIQUE", "CEIL", "REVERSE_V2", "ADD_N", "GATHER_ND", "COS", "WHERE", "RANK", "ELU", "REVERSE_SEQUENCE", "MATRIX_DIAG", "QUANTIZE", "MATRIX_SET_DIAG", "ROUND", "HARD_SWISH", "IF", "WHILE", "NON_MAX_SUPPRESSION_V4", "NON_MAX_SUPPRESSION_V5", "SCATTER_ND", "SELECT_V2", "DENSIFY", "SEGMENT_SUM", "BATCH_MATMUL", "PLACEHOLDER_FOR_GREATER_OP_CODES", "CUMSUM", "CALL_ONCE", "BROADCAST_TO", "RFFT2D", "CONV_3D", "IMAG", "REAL", "COMPLEX_ABS", "HASHTABLE", "HASHTABLE_FIND", "HASHTABLE_IMPORT", "HASHTABLE_SIZE", "REDUCE_ALL", "CONV_3D_TRANSPOSE", "VAR_HANDLE", "READ_VARIABLE", "ASSIGN_VARIABLE", "BROADCAST_ARGS", "RANDOM_STANDARD_NORMAL", "BUCKETIZE", "RANDOM_UNIFORM", "MULTINOMIAL", "GELU", "DYNAMIC_UPDATE_SLICE", "RELU_0_TO_1", "UNSORTED_SEGMENT_PROD", "UNSORTED_SEGMENT_MAX", "UNSORTED_SEGMENT_SUM", "ATAN2", "UNSORTED_SEGMENT_MIN", "SIGN"};

    private BuiltinOperator() {
    }

    public static String name(int i) {
        return names[i];
    }
}
